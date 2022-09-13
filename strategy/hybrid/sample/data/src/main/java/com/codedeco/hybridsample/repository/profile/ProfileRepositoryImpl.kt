package com.codedeco.hybridsample.repository.profile

import com.codedeco.hybridsample.Api
import com.codedeco.hybridsample.Cache
import com.codedeco.hybridsample.entity.Profile

class ProfileRepositoryImpl : ProfileRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getProfile(): Profile? {
        return cache.getProfile() ?: api.getProfile()
    }
}