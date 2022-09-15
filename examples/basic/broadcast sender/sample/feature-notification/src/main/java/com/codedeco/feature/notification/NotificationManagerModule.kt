package com.codedeco.feature.notification

import com.codedeco.framework.notification.NotificationManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface NotificationManagerModule {
    @ViewModelScoped
    @Binds
    fun bindNotificationManager(manager: NotificationManagerImpl): NotificationManager
}