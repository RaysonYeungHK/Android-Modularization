package com.codedeco.feature.environment.application.lifecycle.observer

import android.app.Application
import android.util.Log
import com.codedeco.framework.application.lifecycle.ApplicationLifeCycle
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleEventObserver
import javax.inject.Inject

class EnvironmentApplicationLifecycleEventObserver @Inject constructor() :
    ApplicationLifecycleEventObserver {
    override fun onStateChanged(application: Application, event: ApplicationLifeCycle.Event) {
        Log.d("Feature-Environment", "onStateChanged $event")
    }
}