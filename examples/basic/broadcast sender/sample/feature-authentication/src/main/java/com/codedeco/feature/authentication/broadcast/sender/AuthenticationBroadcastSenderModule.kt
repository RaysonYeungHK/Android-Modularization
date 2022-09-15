package com.codedeco.feature.authentication.broadcast.sender

import com.codedeco.framework.broadcast.sender.BroadcastSender
import com.codedeco.framework.broadcast.sender.BroadcastSenderKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AuthenticationBroadcastSenderModule {
    @Singleton
    @Binds
    @IntoMap
    @BroadcastSenderKey(AuthenticationBroadcastSenderImpl::class)
    fun bindAuthenticationBroadcastSender(broadcastSender: AuthenticationBroadcastSenderImpl): BroadcastSender
}