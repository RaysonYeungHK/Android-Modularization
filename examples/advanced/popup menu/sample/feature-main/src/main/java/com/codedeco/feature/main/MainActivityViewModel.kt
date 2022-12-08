package com.codedeco.feature.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.popupmenu.PopupMenu
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    application: Application,
    val popupMenu: PopupMenu
) : AndroidViewModel(application)