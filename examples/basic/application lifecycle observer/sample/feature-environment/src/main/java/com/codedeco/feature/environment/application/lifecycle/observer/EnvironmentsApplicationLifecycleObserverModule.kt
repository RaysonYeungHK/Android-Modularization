package com.codedeco.feature.environment.application.lifecycle.observer

import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserver
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserverKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface EnvironmentsApplicationLifecycleObserverModule {
    @Binds
    @IntoMap
    @ApplicationLifecycleObserverKey(EnvironmentApplicationLifecycleEventObserver::class)
    fun bindEnvironmentApplicationLifecycleEventObserver(observer: EnvironmentApplicationLifecycleEventObserver): ApplicationLifecycleObserver
}