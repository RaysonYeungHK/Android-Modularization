package com.codedeco.framework.broadcast

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.codedeco.framework.broadcast.listener.BroadcastListener
import java.lang.ref.WeakReference

abstract class Broadcast {
    // Timing to register the broadcast
    open val registerLifecycle: Lifecycle.Event = Lifecycle.Event.ON_CREATE

    // Timing to unregister the broadcast
    open val unregisterLifecycle: Lifecycle.Event = Lifecycle.Event.ON_DESTROY

    // References for all listeners that stored in BroadcastRegister
    protected lateinit var listeners: List<WeakReference<BroadcastListener>>

    abstract val receiver: BroadcastReceiver
    abstract val filter: IntentFilter

    @CallSuper
    open fun onLifecycle(
        activity: Activity,
        event: Lifecycle.Event,
        listeners: List<WeakReference<BroadcastListener>>
    ) {
        when (event) {
            registerLifecycle -> {
                try {
                    LocalBroadcastManager.getInstance(activity).registerReceiver(receiver, filter)
                    this.listeners = listeners
                    Log.d(
                        activity::class.java.simpleName,
                        "$event: register broadcast ${this::class.java.simpleName}"
                    )
                } catch (exception: Exception) {
                    Log.e(this::class.java.simpleName, exception.toString())
                }
            }
            unregisterLifecycle -> {
                try {
                    LocalBroadcastManager.getInstance(activity).unregisterReceiver(receiver)
                    Log.d(
                        activity::class.java.simpleName,
                        "$event: unregister broadcast ${this::class.java.simpleName}"
                    )
                } catch (exception: Exception) {
                    Log.e(this::class.java.simpleName, exception.toString())
                }
            }
            else -> {
                // DO nothing
            }
        }
    }
}