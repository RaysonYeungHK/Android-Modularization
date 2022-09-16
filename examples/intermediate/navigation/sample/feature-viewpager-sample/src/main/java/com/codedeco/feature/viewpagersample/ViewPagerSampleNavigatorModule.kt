package com.codedeco.feature.viewpagersample

import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.NavigatorKey
import com.codedeco.framework.navigation.navigator.ViewPagerSampleNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ViewPagerSampleNavigatorModule {
    @Singleton
    @Binds
    @IntoMap
    @NavigatorKey(ViewPagerSampleNavigator::class)
    fun bindViewPagerSampleNavigator(navigator: ViewPagerSampleNavigatorImpl): Navigator
}