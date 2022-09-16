package com.codedeco.feature.viewpagersample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.navigation.factory.NavigatorFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewPagerSampleFragmentViewModel @Inject constructor(
    application: Application,
    val navigatorFactory: NavigatorFactory
) : AndroidViewModel(application)