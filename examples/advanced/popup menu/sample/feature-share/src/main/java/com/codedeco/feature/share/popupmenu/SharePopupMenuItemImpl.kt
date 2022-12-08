package com.codedeco.feature.share.popupmenu

import android.util.Log
import com.codedeco.feature.authentication.R
import com.codedeco.framework.popupmenu.PopupMenu
import com.codedeco.framework.popupmenu.item.SharePopupMenuItem
import javax.inject.Inject

class SharePopupMenuItemImpl @Inject constructor() : SharePopupMenuItem() {
    override val prefixDrawableRes: Int = android.R.drawable.ic_menu_share
    override val suffixDrawableRes: Int = android.R.drawable.ic_menu_share
    override val stringRes: Int = R.string.share_popup_menu_text
    override val isEnabled: Boolean = true

    override fun performClick(metadata: PopupMenu.Metadata): Boolean {
        metadata.shareMetadata?.run {
            Log.d("SharePopupMenuItem", "performClick ${this@run}")
            return true
        }
        return false
    }
}