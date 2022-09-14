package com.codedeco.framework.application.lifecycle.observer.factory

import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleObserver
import javax.inject.Inject
import javax.inject.Provider

open class ApplicationLifecycleObserverFactoryImpl @Inject constructor(
    private val map: Map<Class<out ApplicationLifecycleObserver>, @JvmSuppressWildcards Provider<ApplicationLifecycleObserver>>
) : ApplicationLifecycleObserverFactory {
    override fun getObservers(): List<ApplicationLifecycleObserver> {
        return map.values.map { provider ->
            provider.get()
        }
    }
}