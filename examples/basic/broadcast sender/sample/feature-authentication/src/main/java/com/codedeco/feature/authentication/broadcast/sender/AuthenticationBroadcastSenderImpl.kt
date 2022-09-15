package com.codedeco.feature.authentication.broadcast.sender

import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender
import com.codedeco.framework.broadcast.sender.BroadcastSender
import javax.inject.Inject

class AuthenticationBroadcastSenderImpl @Inject constructor() : AuthenticationBroadcastSender {
    override fun createIntent(): Intent {
        return Intent(AuthenticationBroadcastSender.BROADCAST_ACTION)
    }

    override fun createIntent(data: AuthenticationBroadcastSender.Data): Intent {
        return createIntent().apply {
            putExtra(BroadcastSender.EXTRA_DATA, data)
        }
    }

    override fun sendBroadcast(context: Context, intent: Intent) {
        // Sender class defines the broadcast channel that will be used
        LocalBroadcastManager.getInstance(context)
            .sendBroadcast(intent)
    }
}