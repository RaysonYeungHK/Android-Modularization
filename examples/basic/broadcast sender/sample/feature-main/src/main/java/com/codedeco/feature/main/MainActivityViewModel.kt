package com.codedeco.feature.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.authentication.AuthenticationManager
import com.codedeco.framework.notification.NotificationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    application: Application,
    private val notificationManager: NotificationManager,
    private val authenticationManager: AuthenticationManager
) : AndroidViewModel(application) {
    fun onAddNotificationClick() {
        notificationManager.addNotification()
    }

    fun onRemoveNotificationClick() {
        notificationManager.removeNotification()
    }

    fun onLoginClick() {
        authenticationManager.login()
    }

    fun onLogoutClick() {
        authenticationManager.login()
    }
}