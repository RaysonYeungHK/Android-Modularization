package com.codedeco.feature.b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.share.FeatureAServiceProvider
import com.codedeco.share.FeatureBServiceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class FeatureBViewModel @Inject constructor(
    application: Application,
    private val featureAServiceProvider: Provider<FeatureAServiceProvider>,
    private val featureBServiceProvider: Provider<FeatureBServiceProvider>
) : AndroidViewModel(application) {
    fun onAction() {
        featureBServiceProvider.get().provideService()
    }
}