package com.codedeco.framework.broadcast

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BroadcastFactoryModule {
    @Singleton
    @Binds
    fun bindBroadcastFactory(factory: BroadcastFactoryImpl): BroadcastFactory
}