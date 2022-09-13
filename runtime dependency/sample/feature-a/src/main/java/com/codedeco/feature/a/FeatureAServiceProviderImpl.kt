package com.codedeco.feature.a

import com.codedeco.share.serviceprovider.FeatureAServiceProvider
import javax.inject.Inject

class FeatureAServiceProviderImpl @Inject constructor() : FeatureAServiceProvider {
    override fun provideAService() {
        // Do nothing
    }
}