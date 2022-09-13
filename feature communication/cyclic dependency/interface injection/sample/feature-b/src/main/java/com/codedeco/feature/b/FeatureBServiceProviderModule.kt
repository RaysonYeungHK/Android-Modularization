package com.codedeco.feature.b

import com.codedeco.share.FeatureBServiceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FeatureBServiceProviderModule {
    @Binds
    fun bindFeatureBServiceProvider(serviceProvider: FeatureBServiceProviderImpl): FeatureBServiceProvider
}