package com.codedeco.feature.subfragment

import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.NavigatorKey
import com.codedeco.framework.navigation.navigator.SubFragmentNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SubFragmentNavigatorModule {
    @Singleton
    @Binds
    @IntoMap
    @NavigatorKey(SubFragmentNavigator::class)
    fun bindSubFragmentNavigator(navigator: SubFragmentNavigatorImpl): Navigator
}