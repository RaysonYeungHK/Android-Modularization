package com.codedeco.featurebasesample.framework

import com.codedeco.featurebasesample.framework.profile.Profile

interface Api {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}