package com.codedeco.feature.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.broadcast.listener.AuthenticationBroadcastListener
import com.codedeco.framework.broadcast.listener.NotificationBroadcastListener
import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender
import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender
import com.codedeco.framework.broadcast.sender.factory.BroadcastSenderFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    application: Application,
    private val broadcastSenderFactory: BroadcastSenderFactory
) : AndroidViewModel(application), AuthenticationBroadcastListener, NotificationBroadcastListener {

    private val notificationCount = AtomicLong(0)

    fun onAddNotificationClick() {
        broadcastSenderFactory.get(NotificationBroadcastSender::class.java)
            ?.run {
                val intent = createIntent(
                    NotificationBroadcastSender.Data(
                        notificationCount = notificationCount.incrementAndGet()
                    )
                )
                sendLocalBroadcast(getApplication(), intent)
            }
    }

    fun onRemoveNotificationClick() {
        broadcastSenderFactory.get(NotificationBroadcastSender::class.java)
            ?.run {
                val intent = createIntent(
                    NotificationBroadcastSender.Data(
                        notificationCount = notificationCount.decrementAndGet()
                    )
                )
                sendLocalBroadcast(getApplication(), intent)
            }
    }

    fun onLoginClick() {
        broadcastSenderFactory.get(AuthenticationBroadcastSender::class.java)
            ?.run {
                val intent = createIntent(
                    AuthenticationBroadcastSender.Data(
                        isLogin = true
                    )
                )
                sendLocalBroadcast(getApplication(), intent)
            }
    }

    fun onLogoutClick() {
        broadcastSenderFactory.get(AuthenticationBroadcastSender::class.java)
            ?.run {
                val intent = createIntent(
                    AuthenticationBroadcastSender.Data(
                        isLogin = false
                    )
                )
                sendLocalBroadcast(getApplication(), intent)
            }
    }

    override fun onAuthenticationChange(data: AuthenticationBroadcastSender.Data) {
        Log.d("MainActivityViewModel", "onAuthenticationChange $data")
    }

    override fun onNotificationChange(data: NotificationBroadcastSender.Data) {
        Log.d("MainActivityViewModel", "onNotificationChange $data")
    }
}