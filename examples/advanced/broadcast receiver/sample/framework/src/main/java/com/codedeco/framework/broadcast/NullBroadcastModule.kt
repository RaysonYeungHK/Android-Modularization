package com.codedeco.framework.broadcast

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface NullBroadcastModule {
    @Binds
    @IntoMap
    @BroadcastKey(NullBroadcast::class)
    fun bindNullBroadcast(broadcast: NullBroadcast): Broadcast
}