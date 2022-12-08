package com.codedeco.framework.popupmenu.item

import android.content.Context
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.codedeco.framework.popupmenu.PopupMenu
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.parcelize.Parcelize

abstract class PopupMenuItem {
    @get:DrawableRes
    abstract val prefixDrawableRes: Int?

    @get:DrawableRes
    abstract val suffixDrawableRes: Int?

    @get:StringRes
    abstract val stringRes: Int

    abstract val isEnabled: Boolean

    abstract fun performClick(
        metadata: PopupMenu.Metadata
    ): Boolean

    @Parcelize
    data class Metadata(
        val anyCommonData: String? = null
    ) : Parcelable
}