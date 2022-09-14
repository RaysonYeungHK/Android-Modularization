package com.codedeco.framework.application.lifecycle.observer.factory

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApplicationLifecycleObserverFactoryModule {
    @Singleton
    @Binds
    fun bindsApplicationLifecycleObserverFactory(
        factory: ApplicationLifecycleObserverFactoryImpl
    ): ApplicationLifecycleObserverFactory
}