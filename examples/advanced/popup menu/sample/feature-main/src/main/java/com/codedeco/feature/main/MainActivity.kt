package com.codedeco.feature.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.framework.popupmenu.PopupMenu
import com.codedeco.framework.popupmenu.item.BookmarkPopupMenuItem
import com.codedeco.framework.popupmenu.item.SharePopupMenuItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun example(anchorView: View, metadata: PopupMenu.Metadata) {
        viewModel.popupMenu.apply {
            setMetadata(metadata)
            show(
                anchorView, listOf(
                    BookmarkPopupMenuItem::class.java,
                    SharePopupMenuItem::class.java
                )
            )
        }
    }

    fun differentOrderExample(anchorView: View, metadata: PopupMenu.Metadata) {
        viewModel.popupMenu.apply {
            setMetadata(metadata)
            show(
                anchorView, listOf(
                    SharePopupMenuItem::class.java,
                    BookmarkPopupMenuItem::class.java
                )
            )
        }
    }

    fun bookmarkOnlyExample(anchorView: View, metadata: PopupMenu.Metadata) {
        viewModel.popupMenu.apply {
            setMetadata(metadata)
            show(
                anchorView, listOf(
                    BookmarkPopupMenuItem::class.java
                )
            )
        }
    }

    fun shareOnlyExample(anchorView: View, metadata: PopupMenu.Metadata) {
        viewModel.popupMenu.apply {
            setMetadata(metadata)
            show(
                anchorView, listOf(
                    SharePopupMenuItem::class.java
                )
            )
        }
    }
}