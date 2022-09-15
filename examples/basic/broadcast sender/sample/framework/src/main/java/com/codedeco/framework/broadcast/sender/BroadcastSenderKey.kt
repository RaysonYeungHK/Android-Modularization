package com.codedeco.framework.broadcast.sender

import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class BroadcastSenderKey(val value: KClass<out BroadcastSender>)