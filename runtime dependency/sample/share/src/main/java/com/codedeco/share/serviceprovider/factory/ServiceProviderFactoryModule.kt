package com.codedeco.share.serviceprovider.factory

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ServiceProviderFactoryModule {
    @Singleton
    @Binds
    fun bindServiceProviderFactory(factory: ServiceProviderFactoryImpl): ServiceProviderFactory
}