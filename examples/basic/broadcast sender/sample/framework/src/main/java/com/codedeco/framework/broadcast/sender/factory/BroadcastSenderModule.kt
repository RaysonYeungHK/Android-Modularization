package com.codedeco.framework.broadcast.sender.factory

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BroadcastSenderModule {
    @Singleton
    @Binds
    fun bindBroadcastSenderFactory(factory: BroadcastSenderFactoryImpl): BroadcastSenderFactory
}