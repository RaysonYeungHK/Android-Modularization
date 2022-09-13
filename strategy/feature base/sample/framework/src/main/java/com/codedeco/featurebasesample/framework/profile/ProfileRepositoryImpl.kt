package com.codedeco.featurebasesample.framework.profile

import com.codedeco.featurebasesample.framework.Api
import com.codedeco.featurebasesample.framework.Cache

class ProfileRepositoryImpl : ProfileRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getProfile(): Profile? {
        return cache.getProfile() ?: api.getProfile()
    }
}