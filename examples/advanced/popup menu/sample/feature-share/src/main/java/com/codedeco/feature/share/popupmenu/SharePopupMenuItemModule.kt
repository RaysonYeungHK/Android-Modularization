package com.codedeco.feature.share.popupmenu

import com.codedeco.framework.popupmenu.item.PopupMenuItem
import com.codedeco.framework.popupmenu.item.PopupMenuItemKey
import com.codedeco.framework.popupmenu.item.SharePopupMenuItem
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SharePopupMenuItemModule {
    @Singleton
    @Binds
    @IntoMap
    @PopupMenuItemKey(SharePopupMenuItem::class)
    fun bindSharePopupMenuItem(menuItem: SharePopupMenuItemImpl): PopupMenuItem
}