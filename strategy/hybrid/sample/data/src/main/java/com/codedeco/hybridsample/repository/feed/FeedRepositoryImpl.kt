package com.codedeco.hybridsample.repository.feed

import com.codedeco.hybridsample.Api
import com.codedeco.hybridsample.Cache

class FeedRepositoryImpl : FeedRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getFeed(): List<String>? {
        return cache.getFeed() ?: api.getFeed()
    }
}