package com.codedeco.framework.application.lifecycle.observer

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NullApplicationLifecycleObserverModule {
    @Singleton
    @Binds
    @IntoMap
    @ApplicationLifecycleObserverKey(NullApplicationLifecycleObserver::class)
    abstract fun bindNullApplicationLifecycleEventObserver(observer: NullApplicationLifecycleObserver): ApplicationLifecycleObserver
}