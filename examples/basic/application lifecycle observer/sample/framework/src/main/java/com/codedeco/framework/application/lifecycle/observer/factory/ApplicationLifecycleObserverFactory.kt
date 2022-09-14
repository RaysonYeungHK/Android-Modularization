package com.codedeco.framework.application.lifecycle.observer.factory

import androidx.annotation.MainThread
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserver
import javax.annotation.Nullable

interface ApplicationLifecycleObserverFactory {
    @Nullable
    @MainThread
    fun getObservers(): List<ApplicationLifecycleObserver>
}