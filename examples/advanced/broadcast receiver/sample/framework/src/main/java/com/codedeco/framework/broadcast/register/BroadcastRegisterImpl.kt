package com.codedeco.framework.broadcast.register

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.codedeco.framework.broadcast.Broadcast
import com.codedeco.framework.broadcast.BroadcastFactory
import com.codedeco.framework.broadcast.NullBroadcast
import com.codedeco.framework.broadcast.listener.BroadcastListener
import java.lang.ref.WeakReference
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.locks.ReentrantLock
import javax.inject.Inject

class BroadcastRegisterImpl @Inject constructor(
    broadcastFactory: BroadcastFactory
) : BroadcastRegister {
    private var activity: WeakReference<AppCompatActivity>? = null

    // Get all broadcasts of the application
    private val broadcasts = broadcastFactory.getBroadcasts().filter {
        it !is NullBroadcast
    }
    // Keep all listeners as weak reference
    private val listeners = ConcurrentLinkedDeque<WeakReference<BroadcastListener>>()

    // Forward lifecycle of activity to all broadcast
    private val lifecycleObserver = LifecycleEventObserver { source, event ->
        when (event) {
            Lifecycle.Event.ON_CREATE,
            Lifecycle.Event.ON_START,
            Lifecycle.Event.ON_RESUME,
            Lifecycle.Event.ON_PAUSE,
            Lifecycle.Event.ON_STOP,
            Lifecycle.Event.ON_DESTROY -> {
                activity?.get()?.let { activity ->
                    broadcasts.forEach { broadcast ->
                        broadcast.onLifecycle(activity, event, listeners.toList())
                    }
                }
            }
            else -> {
                // Do nothing
            }
        }
    }

    override fun attach(activity: AppCompatActivity) {
        this.activity = WeakReference(activity)
        activity.lifecycle.addObserver(lifecycleObserver)
    }

    override fun register(behaviour: BroadcastListener) {
        add(behaviour)
    }

    override fun unregister(behaviour: BroadcastListener) {
        remove(behaviour)
    }

    private fun get(behaviour: BroadcastListener): WeakReference<BroadcastListener>? {
        for (reference in listeners) {
            if (reference.get() == behaviour) {
                return reference
            }
        }
        return null
    }

    private fun add(behaviour: BroadcastListener) {
        if (get(behaviour) != null) {
            return
        }
        for (reference in listeners) {
            if (reference.get() == behaviour) {
                return
            }
        }
        listeners.add(WeakReference(behaviour))
    }

    private fun remove(behaviour: BroadcastListener) {
        val reference = get(behaviour)
        if (reference != null) {
            listeners.remove(reference)
        }
        return
    }
}