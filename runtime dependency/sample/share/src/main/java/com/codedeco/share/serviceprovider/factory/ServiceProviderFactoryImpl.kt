package com.codedeco.share.serviceprovider.factory

import android.util.Log
import com.codedeco.share.serviceprovider.ServiceProvider
import javax.inject.Inject
import javax.inject.Provider

open class ServiceProviderFactoryImpl @Inject constructor(
    private val map: Map<Class<out ServiceProvider>, @JvmSuppressWildcards Provider<ServiceProvider>>
) : ServiceProviderFactory {
    companion object {
        private const val TAG = "ServiceProviderFactory"
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ServiceProvider> get(modelClass: Class<T>): T? {
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