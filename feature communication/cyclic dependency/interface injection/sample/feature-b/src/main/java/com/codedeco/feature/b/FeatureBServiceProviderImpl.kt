package com.codedeco.feature.b

import com.codedeco.share.FeatureBServiceProvider
import javax.inject.Inject

class FeatureBServiceProviderImpl @Inject constructor() : FeatureBServiceProvider {
    override fun provideService() {
        println("provide service")
    }
}

//class FeatureBServiceProviderImpl @Inject constructor() : FeatureBServiceProvider {
//    override fun provideService() {
//        println("provide another service")
//    }
//}

