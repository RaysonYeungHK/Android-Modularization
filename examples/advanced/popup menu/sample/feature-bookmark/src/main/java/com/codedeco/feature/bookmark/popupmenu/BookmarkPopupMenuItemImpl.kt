package com.codedeco.feature.bookmark.popupmenu

import android.util.Log
import com.codedeco.feature.bookmark.R
import com.codedeco.framework.popupmenu.PopupMenu
import com.codedeco.framework.popupmenu.item.BookmarkPopupMenuItem
import javax.inject.Inject

class BookmarkPopupMenuItemImpl @Inject constructor() : BookmarkPopupMenuItem() {
    override val prefixDrawableRes: Int = android.R.drawable.star_on
    override val suffixDrawableRes: Int? = null
    override val stringRes: Int = R.string.bookmark_menu_item_text
    override val isEnabled: Boolean = true

    override fun performClick(metadata: PopupMenu.Metadata): Boolean {
        metadata.bookmarkMetadata?.run {
            Log.d("BookmarkPopupMenuItem", "performClick ${this@run}")
            return true
        }
        return false
    }
}