package com.codedeco.feature.bookmark.popupmenu

import com.codedeco.framework.popupmenu.item.BookmarkPopupMenuItem
import com.codedeco.framework.popupmenu.item.PopupMenuItem
import com.codedeco.framework.popupmenu.item.PopupMenuItemKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface BookmarkPopupMenuItemModule {
    @Singleton
    @Binds
    @IntoMap
    @PopupMenuItemKey(BookmarkPopupMenuItem::class)
    fun bindBookmarkMenuItem(menuItem: BookmarkPopupMenuItemImpl): PopupMenuItem
}