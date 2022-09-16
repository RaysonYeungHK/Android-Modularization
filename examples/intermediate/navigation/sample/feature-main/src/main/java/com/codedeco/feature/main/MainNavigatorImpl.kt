package com.codedeco.feature.main

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.navigator.MainNavigator
import javax.inject.Inject

class MainNavigatorImpl @Inject constructor() : MainNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, MainActivity::class.java)
    }

    override fun createFragment(): Fragment {
        return MainFragment()
    }
}