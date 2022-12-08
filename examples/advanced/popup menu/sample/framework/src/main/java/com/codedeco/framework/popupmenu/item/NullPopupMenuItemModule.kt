package com.codedeco.framework.popupmenu.item

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NullPopupMenuItemModule {
    @Singleton
    @Binds
    @IntoMap
    @PopupMenuItemKey(NullPopupMenuItem::class)
    abstract fun bindNullPopupMenuItem(menuItem: NullPopupMenuItem): PopupMenuItem
}