# Application lifecycle observer

It is very common to have initialization process when `Application` is created in Android.

Many people used to face the situation like following

```kotlin
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        initLogger()
        initCrashlytics()
        initEnvironment()
        bindServices()
        ...
    }

    override fun onTerminate() {
        super.onTerminate()

        unbindServices()
        resetEnvironment()
        ...
    }

    ...
}
```

When there are lots of implementation in the `App` class, it is difficult to tell what is related to which feature.

With the idea that explained before, instead of putting all implementation in the `App`, implementation are distributed to different feature modules and injected to the `Factory` class.

Dependency on the requirement, the `Factory` class could be adjusted to support series ordering.

This is the final `App` class

```kotlin
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
```

For more detail, please check the sample project

**Sample project**

[Application Lifecycle Observer Sample](./sample)
