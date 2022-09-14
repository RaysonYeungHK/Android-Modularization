package com.codedeco.framework.application.lifecycle.observer

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class NullApplicationLifecycleObserverModule {
    @Binds
    @IntoMap
    @ApplicationLifecycleObserverKey(NullApplicationLifecycleObserver::class)
    abstract fun bindNullApplicationLifecycleEventObserver(observer: NullApplicationLifecycleObserver): ApplicationLifecycleObserver
}