package com.codedeco.feature.crashlytics.application.lifecycle.observer

import android.app.Application
import android.util.Log
import com.codedeco.framework.application.lifecycle.ApplicationLifeCycle
import com.codedeco.framework.application.lifecycle.observer.ApplicationLifecycleEventObserver
import javax.inject.Inject

class CrashlyticsApplicationLifecycleEventObserver @Inject constructor() :
    ApplicationLifecycleEventObserver {
    override fun onStateChanged(application: Application, event: ApplicationLifeCycle.Event) {
        Log.d("Feature-Crashlytics", "onStateChanged $event")
    }
}