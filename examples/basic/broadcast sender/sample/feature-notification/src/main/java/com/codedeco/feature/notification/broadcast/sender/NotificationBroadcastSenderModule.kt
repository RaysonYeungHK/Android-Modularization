package com.codedeco.feature.notification.broadcast.sender

import com.codedeco.framework.broadcast.sender.BroadcastSender
import com.codedeco.framework.broadcast.sender.BroadcastSenderKey
import com.codedeco.framework.broadcast.sender.NotificationBroadcastSender
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NotificationBroadcastSenderModule {
    @Singleton
    @Binds
    @IntoMap
    @BroadcastSenderKey(NotificationBroadcastSender::class)
    fun bindNotificationBroadcastSender(broadcastSender: NotificationBroadcastSenderImpl): BroadcastSender
}