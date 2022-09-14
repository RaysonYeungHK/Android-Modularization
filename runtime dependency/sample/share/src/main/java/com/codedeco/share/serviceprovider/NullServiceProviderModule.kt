package com.codedeco.share.serviceprovider

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface NullServiceProviderModule {
    @Binds
    @IntoMap
    @ServiceProviderKey(NullServiceProvider::class)
    fun bindNullServiceProvider(serviceProvider: NullServiceProvider): ServiceProvider
}