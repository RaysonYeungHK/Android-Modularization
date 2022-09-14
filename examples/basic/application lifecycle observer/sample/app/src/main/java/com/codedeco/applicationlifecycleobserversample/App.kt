package com.codedeco.applicationlifecycleobserversample

import android.app.Application
import com.codedeco.framework.application.lifecycle.ApplicationLifeCycle
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleEventObserver
import com.codedeco.framework.application.lifecycle.observer.NullApplicationLifecycleObserver
import com.codedeco.framework.application.lifecycle.observer.factory.ApplicationLifecycleObserverFactory
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var applicationLifecycleObserverFactory: ApplicationLifecycleObserverFactory

    override fun onCreate() {
        super.onCreate()

        applicationLifecycleObserverFactory.getObservers().filter {
            it !is NullApplicationLifecycleObserver
        }.forEach {
            if (it is ApplicationLifecycleEventObserver) {
                it.onStateChanged(this@App, ApplicationLifeCycle.Event.OnCreate)
            }
        }
    }

    override fun onTerminate() {
        super.onTerminate()

        applicationLifecycleObserverFactory.getObservers().filter {
            it !is NullApplicationLifecycleObserver
        }.forEach {
            if (it is ApplicationLifecycleEventObserver) {
                it.onStateChanged(this@App, ApplicationLifeCycle.Event.OnTerminate)
            }
        }
    }
}