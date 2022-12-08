package com.codedeco.framework.broadcast.register

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
interface BroadcastRegisterModule {
    @Binds
    @ActivityScoped
    fun bindBroadcastRegister(register: BroadcastRegisterImpl): BroadcastRegister
}