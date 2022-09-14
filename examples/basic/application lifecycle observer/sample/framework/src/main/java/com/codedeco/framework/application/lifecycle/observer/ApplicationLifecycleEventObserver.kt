package com.codedeco.framework.application.lifecycle.observer

import android.app.Application
import com.codedeco.framework.application.lifecycle.ApplicationLifeCycle

interface ApplicationLifecycleEventObserver : ApplicationLifecycleObserver {
    fun onStateChanged(application: Application, event: ApplicationLifeCycle.Event)
}