package com.codedeco.framework.broadcast.listener

import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender

interface NotificationBroadcastListener : BroadcastListener {
    fun onNotificationChange(data: NotificationBroadcastSender.Data)
}