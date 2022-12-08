package com.codedeco.framework.broadcast.sender

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

interface AuthenticationBroadcastSender : BroadcastSender {
    companion object {
        const val BROADCAST_ACTION = "com.codedec.feature.authentication.BROADCAST_ACTION"
    }

    fun createIntent(data: Data): Intent

    fun getData(intent: Intent?): Data?

    fun sendBroadcast(context: Context, intent: Intent)

    @Parcelize
    data class Data(
        val isLogin: Boolean
    ) : Parcelable
}