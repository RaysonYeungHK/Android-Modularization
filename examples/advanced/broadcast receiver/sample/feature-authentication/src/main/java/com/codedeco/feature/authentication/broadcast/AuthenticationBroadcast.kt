package com.codedeco.feature.authentication.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.codedeco.framework.broadcast.Broadcast
import com.codedeco.framework.broadcast.listener.AuthenticationBroadcastListener
import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender
import com.codedeco.framework.broadcast.sender.factory.BroadcastSenderFactory
import javax.inject.Inject

class AuthenticationBroadcast @Inject constructor(
    private val broadcastSenderFactory: BroadcastSenderFactory
) : Broadcast() {
    override val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            broadcastSenderFactory.get(AuthenticationBroadcastSender::class.java)
                ?.getData(intent)
                ?.run {
                    notifyListeners(this@run)
                }
        }
    }

    override val filter = IntentFilter().apply {
        addAction(AuthenticationBroadcastSender.BROADCAST_ACTION)
    }

    private fun notifyListeners(data: AuthenticationBroadcastSender.Data) {
        listeners.map {
            it.get()
        }.filterIsInstance<AuthenticationBroadcastListener>().forEach {
            it.onAuthenticationChange(data)
        }
    }
}