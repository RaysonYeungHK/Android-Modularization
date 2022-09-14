package com.codedeco.framework.application.lifecycle.observer

import android.app.Application
import com.codedeco.framework.application.lifecycle.ApplicationLifeCycle
import javax.inject.Inject

class NullApplicationLifecycleObserver @Inject constructor() : ApplicationLifecycleEventObserver {
    init {
        throw IllegalAccessException("You should not access this class")
    }

    override fun onStateChanged(application: Application, event: ApplicationLifeCycle.Event) {
        throw IllegalAccessException("You should not access this class")
    }
}