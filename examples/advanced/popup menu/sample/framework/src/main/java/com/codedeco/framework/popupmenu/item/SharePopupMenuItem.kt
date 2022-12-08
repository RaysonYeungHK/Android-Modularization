package com.codedeco.framework.popupmenu.item

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

abstract class SharePopupMenuItem : PopupMenuItem() {
    @Parcelize
    data class Metadata(
        val textToShare: String
    ) : Parcelable
}