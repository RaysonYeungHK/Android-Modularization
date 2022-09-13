package com.codedeco.feature.a

import com.codedeco.share.FeatureAServiceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface FeatureAServiceProviderModule {
    @Binds
    fun bindFeatureAServiceProvider(serviceProvider: FeatureAServiceProviderImpl): FeatureAServiceProvider
}