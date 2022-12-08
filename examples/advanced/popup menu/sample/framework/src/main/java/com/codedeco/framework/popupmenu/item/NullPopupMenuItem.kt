package com.codedeco.framework.popupmenu.item

import com.codedeco.framework.popupmenu.PopupMenu
import javax.inject.Inject

class NullPopupMenuItem @Inject constructor() : PopupMenuItem() {
    override val prefixDrawableRes: Int
        get() = throw IllegalAccessException()
    override val suffixDrawableRes: Int
        get() = throw IllegalAccessException()
    override val stringRes: Int
        get() = throw IllegalAccessException()
    override val isEnabled: Boolean
        get() = throw IllegalAccessException()

    override fun performClick(metadata: PopupMenu.Metadata): Boolean {
        throw IllegalAccessException()
    }
}