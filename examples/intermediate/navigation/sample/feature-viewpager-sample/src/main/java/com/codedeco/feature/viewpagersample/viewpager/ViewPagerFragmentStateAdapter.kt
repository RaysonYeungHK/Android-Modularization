package com.codedeco.feature.viewpagersample.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codedeco.framework.navigation.factory.NavigatorFactory
import com.codedeco.framework.navigation.navigator.SubFragmentNavigator

class ViewPagerFragmentStateAdapter : FragmentStateAdapter {
    constructor(fragmentActivity: FragmentActivity, navigatorFactory: NavigatorFactory)
            : super(fragmentActivity) {
        this.navigatorFactory = navigatorFactory
    }

    constructor(fragment: Fragment, navigatorFactory: NavigatorFactory)
            : super(fragment) {
        this.navigatorFactory = navigatorFactory
    }

    constructor(fragmentManager: FragmentManager, lifecycle: Lifecycle, navigatorFactory: NavigatorFactory)
            : super(fragmentManager, lifecycle) {
        this.navigatorFactory = navigatorFactory
    }

    private val navigatorFactory: NavigatorFactory

    override fun getItemCount(): Int {
        // just hard code for sample
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return navigatorFactory.get(SubFragmentNavigator::class.java)
            ?.createFragment(SubFragmentNavigator.Param(position)) ?: throw NullPointerException()
    }
}