package com.codedeco.feature.notification.broadcast

import com.codedeco.framework.broadcast.Broadcast
import com.codedeco.framework.broadcast.BroadcastKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface NotificationBroadcastModule {
    @Binds
    @IntoMap
    @BroadcastKey(NotificationBroadcast::class)
    fun bindNotificationBroadcast(broadcast: NotificationBroadcast): Broadcast
}