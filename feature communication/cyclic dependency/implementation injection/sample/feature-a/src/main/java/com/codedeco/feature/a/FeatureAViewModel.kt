package com.codedeco.feature.a

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.share.FeatureAServiceProvider
import com.codedeco.share.FeatureBServiceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    application: Application,
    private val featureAServiceProvider: FeatureAServiceProvider,
    private val featureBServiceProvider: FeatureBServiceProvider
) : AndroidViewModel(application) {
    fun onAction() {
        featureBServiceProvider.provideService()
    }
}