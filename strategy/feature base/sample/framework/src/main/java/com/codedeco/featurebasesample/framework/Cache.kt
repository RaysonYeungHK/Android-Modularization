package com.codedeco.featurebasesample.framework

import com.codedeco.featurebasesample.framework.profile.Profile

interface Cache {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}