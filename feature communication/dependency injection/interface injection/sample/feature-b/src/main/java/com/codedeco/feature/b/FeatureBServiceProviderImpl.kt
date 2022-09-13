package com.codedeco.feature.b

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

