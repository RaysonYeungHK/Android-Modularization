package com.codedeco.feature.b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.share.FeatureAServiceProvider
import com.codedeco.share.FeatureBServiceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureBViewModel @Inject constructor(
    application: Application,
    private val featureAServiceProvider: FeatureAServiceProvider,
    private val featureBServiceProvider: FeatureBServiceProvider
) : AndroidViewModel(application)