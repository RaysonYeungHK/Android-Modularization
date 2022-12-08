package com.codedeco.framework.broadcast.sender

import android.content.Intent
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface NotificationBroadcastSender : BroadcastSender {
    companion object {
        const val BROADCAST_ACTION = "com.codedec.feature.notification.BROADCAST_ACTION"
    }

    fun createIntent(data: Data): Intent

    fun getData(intent: Intent?): Data?

    @Parcelize
    data class Data(
        val notificationCount: Long
    ) : Parcelable
}