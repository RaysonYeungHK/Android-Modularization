package com.codedeco.layerbasesample.repository.profile

import com.codedeco.layerbasesample.Api
import com.codedeco.layerbasesample.Cache
import com.codedeco.layerbasesample.entity.Profile

class ProfileRepositoryImpl : ProfileRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getProfile(): Profile? {
        return cache.getProfile() ?: api.getProfile()
    }
}