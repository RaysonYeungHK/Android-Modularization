package com.codedeco.feature.logger.application.lifecycle.observer

import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserver
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserverKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LoggerApplicationLifecycleObserverModule {
    @Singleton
    @Binds
    @IntoMap
    @ApplicationLifecycleObserverKey(LoggerApplicationLifecycleEventObserver::class)
    fun bindLoggerApplicationLifecycleEventObserver(observer: LoggerApplicationLifecycleEventObserver): ApplicationLifecycleObserver
}