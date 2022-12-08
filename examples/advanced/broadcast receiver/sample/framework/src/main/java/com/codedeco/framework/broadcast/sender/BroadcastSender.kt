package com.codedeco.framework.broadcast.sender

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager

interface BroadcastSender {
    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    fun createIntent(): Intent

    fun sendLocalBroadcast(context: Context, intent: Intent) {
        LocalBroadcastManager.getInstance(context)
            .sendBroadcast(intent)
    }
}