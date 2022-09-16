package com.codedeco.framework.navigation.navigator

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.Navigator

interface SplashNavigator : Navigator {
    fun createIntent(context: Context): Intent
}