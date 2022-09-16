package com.codedeco.feature.main

import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.NavigatorKey
import com.codedeco.framework.navigation.navigator.MainNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MainNavigatorModule {
    @Singleton
    @Binds
    @IntoMap
    @NavigatorKey(MainNavigator::class)
    fun bindMainNavigator(navigator: MainNavigatorImpl): Navigator
}