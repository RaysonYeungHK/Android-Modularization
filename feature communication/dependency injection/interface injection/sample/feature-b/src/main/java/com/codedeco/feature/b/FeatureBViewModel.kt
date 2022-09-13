package com.codedeco.feature.b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureBViewModel @Inject constructor(
    application: Application,
    private val featureBServiceProvider: FeatureBServiceProvider
) : AndroidViewModel(application)