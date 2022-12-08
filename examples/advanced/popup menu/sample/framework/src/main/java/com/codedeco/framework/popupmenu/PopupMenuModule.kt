package com.codedeco.framework.popupmenu

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface PopupMenuModule {
    @Binds
    @ViewModelScoped
    fun bindPopupMenu(popupMenu: PopupMenuImpl): PopupMenu
}