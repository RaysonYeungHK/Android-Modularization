package com.codedeco.layerbasesample

import com.codedeco.layerbasesample.entity.Profile

interface Cache {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}