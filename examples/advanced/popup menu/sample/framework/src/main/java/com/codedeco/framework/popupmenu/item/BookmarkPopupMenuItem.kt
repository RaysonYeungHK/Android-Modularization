package com.codedeco.framework.popupmenu.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

abstract class BookmarkPopupMenuItem : PopupMenuItem() {
    @Parcelize
    data class Metadata(
        val textToBookmark: String
    ) : Parcelable
}