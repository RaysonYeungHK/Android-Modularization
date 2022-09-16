package com.codedeco.feature.viewpagersample

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.navigator.ViewPagerSampleNavigator
import javax.inject.Inject

class ViewPagerSampleNavigatorImpl @Inject constructor(): ViewPagerSampleNavigator {
    override fun createIntent(context: Context): Intent {
        return Intent(context, ViewPagerSampleActivity::class.java)
    }

    override fun createFragment(): Fragment {
        return ViewPagerSampleFragment()
    }
}