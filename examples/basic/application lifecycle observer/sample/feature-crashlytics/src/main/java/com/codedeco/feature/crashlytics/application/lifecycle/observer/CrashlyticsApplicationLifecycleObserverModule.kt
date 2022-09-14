package com.codedeco.feature.crashlytics.application.lifecycle.observer

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
interface CrashlyticsApplicationLifecycleObserverModule {
    @Singleton
    @Binds
    @IntoMap
    @ApplicationLifecycleObserverKey(CrashlyticsApplicationLifecycleEventObserver::class)
    fun bindCrashlyticsApplicationLifecycleEventObserver(observer: CrashlyticsApplicationLifecycleEventObserver): ApplicationLifecycleObserver
}