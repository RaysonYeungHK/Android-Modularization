package com.codedeco.featurebasesample.feature.b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.featurebasesample.framework.login.LoginManager
import com.codedeco.featurebasesample.framework.logout.LogoutManager

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