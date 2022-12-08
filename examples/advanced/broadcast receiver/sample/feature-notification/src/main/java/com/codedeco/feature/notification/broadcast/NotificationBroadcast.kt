package com.codedeco.feature.notification.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.codedeco.framework.broadcast.Broadcast
import com.codedeco.framework.broadcast.listener.NotificationBroadcastListener
import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender
import com.codedeco.framework.broadcast.sender.factory.BroadcastSenderFactory
import javax.inject.Inject

class NotificationBroadcast @Inject constructor(
    private val broadcastSenderFactory: BroadcastSenderFactory
) : Broadcast() {
    override val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            broadcastSenderFactory.get(NotificationBroadcastSender::class.java)
                ?.getData(intent)
                ?.run {
                    notifyListeners(this@run)
                }
        }
    }
    override val filter = IntentFilter().apply {
        addAction(NotificationBroadcastSender.BROADCAST_ACTION)
    }

    private fun notifyListeners(data: NotificationBroadcastSender.Data) {
        listeners.map {
            it.get()
        }.filterIsInstance<NotificationBroadcastListener>().forEach {
            it.onNotificationChange(data)
        }
    }
}