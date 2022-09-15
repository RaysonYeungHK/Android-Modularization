package com.codedeco.feature.notification

import android.content.Context
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender
import com.codedeco.framework.broadcast.sender.factory.BroadcastSenderFactory
import com.codedeco.framework.notification.NotificationManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject

/**
 * Example class to send the broadcast
 * Beware this class is "Compile time strong dependency" injection
 */
class NotificationManagerImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val broadcastSenderFactory: BroadcastSenderFactory
) : NotificationManager {
    private val notificationCount = AtomicLong(0)

    override fun addNotification() {
        broadcastSenderFactory.get(NotificationBroadcastSender::class.java)
            ?.createIntent(NotificationBroadcastSender.Data(notificationCount.incrementAndGet()))
            ?.run {
                // Consumer class defines the broadcast channel that will be used
                LocalBroadcastManager.getInstance(context)
                    .sendBroadcast(this)
            }
    }

    override fun removeNotification() {
        broadcastSenderFactory.get(NotificationBroadcastSender::class.java)
            ?.createIntent(NotificationBroadcastSender.Data(notificationCount.decrementAndGet()))
            ?.run {
                // Consumer class defines the broadcast channel that will be used
                context.sendBroadcast(this)
            }
    }
}