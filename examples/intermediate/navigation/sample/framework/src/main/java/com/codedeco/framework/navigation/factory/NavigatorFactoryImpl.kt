package com.codedeco.framework.navigation.factory

import android.util.Log
import com.codedeco.framework.navigation.Navigator
import javax.inject.Inject
import javax.inject.Provider

open class NavigatorFactoryImpl @Inject constructor(
    private val map: Map<Class<out Navigator>, @JvmSuppressWildcards Provider<Navigator>>
) : NavigatorFactory {
    companion object {
        private const val TAG = "NavigatorFactory"
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Navigator> get(modelClass: Class<T>): T? {
        val provider = map[modelClass] ?: map.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value
        if (provider == null) {
            // You could change to anyway to indicate this situation
            Log.w(TAG, "$modelClass is not yet provided")
        }
        return try {
            provider?.get() as T?
        } catch (e: Exception) {
            throw e
        }
    }
}