package com.codedeco.layerbasesample.viewmodel.featureB

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.layerbasesample.usecase.login.LoginManager
import com.codedeco.layerbasesample.usecase.logout.LogoutManager

class FeatureBActivityViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var loginManager: LoginManager
    private lateinit var logoutManager: LogoutManager

    fun onLoginClick() {
        loginManager.login()
    }

    fun onLogoutClick() {
        logoutManager.logout()
    }
}