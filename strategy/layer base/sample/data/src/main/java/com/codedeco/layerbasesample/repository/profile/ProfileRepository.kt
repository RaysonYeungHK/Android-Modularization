package com.codedeco.layerbasesample.repository.profile

import com.codedeco.layerbasesample.entity.Profile

interface ProfileRepository {
    fun getProfile(): Profile?
}