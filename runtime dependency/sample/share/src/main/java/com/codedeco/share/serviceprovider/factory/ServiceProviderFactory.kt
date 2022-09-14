package com.codedeco.share.serviceprovider.factory

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import com.codedeco.share.serviceprovider.ServiceProvider

interface ServiceProviderFactory {
    @Nullable
    @MainThread
    fun <T : ServiceProvider> get(modelClass: Class<T>): T?
}