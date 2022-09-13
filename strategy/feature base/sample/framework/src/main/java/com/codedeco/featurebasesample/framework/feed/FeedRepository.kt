package com.codedeco.featurebasesample.framework.feed

interface FeedRepository {
    fun getFeed(): List<String>?
}