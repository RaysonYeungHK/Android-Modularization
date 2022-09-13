package com.codedeco.featurebasesample.feature.a

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.featurebasesample.framework.feed.FeedManager
import com.codedeco.featurebasesample.framework.login.LoginManager

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