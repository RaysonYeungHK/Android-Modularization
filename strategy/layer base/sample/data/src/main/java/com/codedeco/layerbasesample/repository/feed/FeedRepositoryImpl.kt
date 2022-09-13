package com.codedeco.layerbasesample.repository.feed

import com.codedeco.layerbasesample.Api
import com.codedeco.layerbasesample.Cache

class FeedRepositoryImpl : FeedRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getFeed(): List<String>? {
        return cache.getFeed() ?: api.getFeed()
    }
}