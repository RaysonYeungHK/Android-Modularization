package com.codedeco.share.serviceprovider

import androidx.annotation.MainThread
import androidx.annotation.Nullable

interface ServiceProviderFactory {
    @Nullable
    @MainThread
    fun <T : ServiceProvider> get(modelClass: Class<T>): T?
}