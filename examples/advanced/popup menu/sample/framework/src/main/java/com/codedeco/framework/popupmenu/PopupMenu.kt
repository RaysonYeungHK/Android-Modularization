package com.codedeco.framework.popupmenu

import android.os.Parcelable
import android.view.View
import com.codedeco.framework.popupmenu.item.BookmarkPopupMenuItem
import com.codedeco.framework.popupmenu.item.PopupMenuItem
import com.codedeco.framework.popupmenu.item.SharePopupMenuItem
import kotlinx.parcelize.Parcelize

abstract class PopupMenu {
    protected lateinit var _metadata: Metadata

    fun setMetadata(metadata: Metadata) = apply {
        this._metadata = metadata
    }

    abstract fun show(
        anchorView: View,
        menuItems: List<Class<out PopupMenuItem>>
    )

    @Parcelize
    data class Metadata(
        val commonMetadata: PopupMenuItem.Metadata? = null,
        val shareMetadata: SharePopupMenuItem.Metadata? = null,
        val bookmarkMetadata: BookmarkPopupMenuItem.Metadata? = null
    ) : Parcelable
}