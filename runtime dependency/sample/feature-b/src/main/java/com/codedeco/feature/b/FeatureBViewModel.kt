package com.codedeco.feature.b

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.share.serviceprovider.FeatureAServiceProvider
import com.codedeco.share.serviceprovider.ServiceProviderFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureBViewModel @Inject constructor(
    application: Application,
    private val serviceProviderFactory: ServiceProviderFactory
) : AndroidViewModel(application) {
    fun onAction() {
        serviceProviderFactory.get(FeatureAServiceProvider::class.java)
            ?.provideAService()
    }
}