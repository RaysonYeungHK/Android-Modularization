package com.codedeco.framework.popupmenu.item

import dagger.MapKey
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class PopupMenuItemKey(val value: KClass<out PopupMenuItem>)