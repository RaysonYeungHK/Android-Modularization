package com.codedeco.layerbasesample.viewmodel.featureA

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.layerbasesample.usecase.feed.FeedManager
import com.codedeco.layerbasesample.usecase.login.LoginManager

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