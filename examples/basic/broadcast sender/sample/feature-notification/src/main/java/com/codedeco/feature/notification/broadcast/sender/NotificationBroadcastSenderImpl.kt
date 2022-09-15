package com.codedeco.feature.notification.broadcast.sender

import android.content.Intent
import com.codedeco.framework.broadcast.sender.BroadcastSender
import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender
import javax.inject.Inject

class NotificationBroadcastSenderImpl @Inject constructor() : NotificationBroadcastSender {
    override fun createIntent(): Intent {
        return Intent(NotificationBroadcastSender.BROADCAST_ACTION)
    }

    override fun createIntent(data: NotificationBroadcastSender.Data): Intent {
        return createIntent().apply {
            putExtra(BroadcastSender.EXTRA_DATA, data)
        }
    }
}