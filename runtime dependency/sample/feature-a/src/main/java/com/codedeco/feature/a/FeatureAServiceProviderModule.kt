package com.codedeco.feature.a

import com.codedeco.share.serviceprovider.FeatureAServiceProvider
import com.codedeco.share.serviceprovider.ServiceProvider
import com.codedeco.share.serviceprovider.ServiceProviderKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface FeatureAServiceProviderModule {
    @Binds
    @IntoMap
    @ServiceProviderKey(FeatureAServiceProvider::class)
    fun bindFeatureAServiceProvider(serviceProvider: FeatureAServiceProviderImpl): ServiceProvider
}