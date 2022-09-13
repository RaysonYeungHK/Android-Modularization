package com.codedeco.featurebasesample.framework.feed

import com.codedeco.featurebasesample.framework.Api
import com.codedeco.featurebasesample.framework.Cache

class FeedRepositoryImpl : FeedRepository {
    private lateinit var api: Api
    private lateinit var cache: Cache

    override fun getFeed(): List<String>? {
        return cache.getFeed() ?: api.getFeed()
    }
}