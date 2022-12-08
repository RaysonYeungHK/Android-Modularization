package com.codedeco.feature.authentication.broadcast

import com.codedeco.framework.broadcast.Broadcast
import com.codedeco.framework.broadcast.BroadcastKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface AuthenticationBroadcastModule {
    @Binds
    @IntoMap
    @BroadcastKey(AuthenticationBroadcast::class)
    abstract fun bindAuthenticationBroadcast(broadcast: AuthenticationBroadcast): Broadcast
}