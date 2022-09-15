package com.codedeco.feature.authentication

import android.content.Context
import com.codedeco.framework.authentication.AuthenticationManager
import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender
import com.codedeco.framework.broadcast.sender.factory.BroadcastSenderFactory
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Example class to send the broadcast
 * Beware this class is "Compile time strong dependency" injection
 */
class AuthenticationManagerImpl @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val broadcastSenderFactory: BroadcastSenderFactory
) : AuthenticationManager {
    override fun login() {
        broadcastSenderFactory.get(AuthenticationBroadcastSender::class.java)
            ?.run {
                sendBroadcast(
                    context,
                    createIntent(AuthenticationBroadcastSender.Data(isLogin = true))
                )
            }
    }

    override fun logout() {
        broadcastSenderFactory.get(AuthenticationBroadcastSender::class.java)
            ?.run {
                sendBroadcast(
                    context,
                    createIntent(AuthenticationBroadcastSender.Data(isLogin = false))
                )
            }
    }
}