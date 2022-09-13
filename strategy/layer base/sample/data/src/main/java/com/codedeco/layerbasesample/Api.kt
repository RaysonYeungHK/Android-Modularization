package com.codedeco.layerbasesample

import com.codedeco.layerbasesample.entity.Profile

interface Api {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}