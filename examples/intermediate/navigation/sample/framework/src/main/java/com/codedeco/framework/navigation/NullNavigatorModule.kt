package com.codedeco.framework.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NullNavigatorModule {
    @Singleton
    @Binds
    @IntoMap
    @NavigatorKey(NullNavigator::class)
    fun bindNullNavigator(navigator: NullNavigator): Navigator
}