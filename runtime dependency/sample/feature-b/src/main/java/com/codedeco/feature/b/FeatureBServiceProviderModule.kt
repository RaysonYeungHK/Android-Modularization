package com.codedeco.feature.b

import com.codedeco.share.serviceprovider.FeatureBServiceProvider
import com.codedeco.share.serviceprovider.ServiceProvider
import com.codedeco.share.serviceprovider.ServiceProviderKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(ViewModelComponent::class)
interface FeatureBServiceProviderModule {
    @Binds
    @IntoMap
    @ServiceProviderKey(FeatureBServiceProvider::class)
    fun bindFeatureBServiceProvider(serviceProvider: FeatureBServiceProviderImpl): ServiceProvider
}