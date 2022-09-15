package com.codedeco.framework.broadcast.sender

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NullBroadcastSenderModule {
    @Singleton
    @Binds
    @IntoMap
    @BroadcastSenderKey(NullBroadcastSender::class)
    abstract fun bindNullBroadcastSender(broadcast: NullBroadcastSender): BroadcastSender
}