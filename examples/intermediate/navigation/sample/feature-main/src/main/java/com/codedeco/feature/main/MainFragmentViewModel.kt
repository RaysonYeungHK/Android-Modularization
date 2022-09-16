package com.codedeco.feature.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.navigation.factory.NavigatorFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    application: Application,
    val navigatorFactory: NavigatorFactory
) : AndroidViewModel(application)