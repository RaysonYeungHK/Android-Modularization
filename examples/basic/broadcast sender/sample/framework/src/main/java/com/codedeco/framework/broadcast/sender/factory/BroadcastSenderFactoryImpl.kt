package com.codedeco.framework.broadcast.sender.factory

import android.util.Log
import com.codedeco.framework.broadcast.sender.BroadcastSender
import javax.inject.Inject
import javax.inject.Provider

open class BroadcastSenderFactoryImpl @Inject constructor(
    private val map: Map<Class<out BroadcastSender>, @JvmSuppressWildcards Provider<BroadcastSender>>
) : BroadcastSenderFactory {
    companion object {
        private const val TAG = "BroadcastSenderFactory"
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : BroadcastSender> get(modelClass: Class<T>): T? {
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
}