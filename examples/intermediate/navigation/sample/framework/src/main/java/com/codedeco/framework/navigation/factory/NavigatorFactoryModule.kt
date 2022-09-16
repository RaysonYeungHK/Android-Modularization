package com.codedeco.framework.navigation.factory

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorFactoryModule {
    @Singleton
    @Binds
    fun bindNavigatorFactory(factory: NavigatorFactoryImpl): NavigatorFactory
}