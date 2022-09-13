package com.codedeco.feature.a

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.feature.b.FeatureBServiceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    application: Application,
    private val featureBServiceProvider: Provider<FeatureBServiceProvider>
) : AndroidViewModel(application) {
    fun onAction() {
        featureBServiceProvider.get().provideService()
    }
}