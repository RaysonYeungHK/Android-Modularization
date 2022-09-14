package com.codedeco.framework.application.lifecycle.observer

import dagger.MapKey
import kotlin.reflect.KClass

@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class ApplicationLifecycleObserverKey(val value: KClass<out ApplicationLifecycleObserver>)