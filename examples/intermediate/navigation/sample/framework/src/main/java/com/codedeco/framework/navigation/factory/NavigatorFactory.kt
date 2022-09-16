package com.codedeco.framework.navigation.factory

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import com.codedeco.framework.navigation.Navigator

interface NavigatorFactory {
    @Nullable
    @MainThread
    fun <T : Navigator> get(modelClass: Class<T>): T?
}