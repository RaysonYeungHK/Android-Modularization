package com.codedeco.feature.a

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.codedeco.share.serviceprovider.FeatureBServiceProvider
import com.codedeco.share.serviceprovider.factory.ServiceProviderFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeatureAViewModel @Inject constructor(
    application: Application,
    private val serviceProviderFactory: ServiceProviderFactory
) : AndroidViewModel(application) {
    fun onAction() {
        serviceProviderFactory.get(FeatureBServiceProvider::class.java)
            ?.provideBService()
    }
}