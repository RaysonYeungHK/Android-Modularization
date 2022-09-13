package com.codedeco.hybridsample.feature.a

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.hybridsample.usecase.feed.FeedManager
import com.codedeco.hybridsample.usecase.login.LoginManager

class FeatureAActivityViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var loginManager: LoginManager
    private lateinit var feedManager: FeedManager

    fun onLoginClick() {
        loginManager.login()
    }

    fun onLogin() {
        feedManager.getFeed()
    }
}