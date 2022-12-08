package com.codedeco.framework.broadcast

import android.util.Log
import javax.inject.Inject
import javax.inject.Provider

open class BroadcastFactoryImpl @Inject constructor(
    private val map: Map<Class<out Broadcast>, @JvmSuppressWildcards Provider<Broadcast>>
) : BroadcastFactory {
    companion object {
        private const val TAG = "BroadcastFactory"
    }

    override fun <T : Broadcast> get(modelClass: Class<T>): T? {
        val provider = map[modelClass] ?: map.asIterable().firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value
        if (provider == null) {
            Log.w(TAG, "$modelClass is not yet provided")
        }
        return try {
            provider?.get() as T?
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getBroadcasts(): List<Broadcast> {
        return map.values.map {
            it.get()
        }
    }
}