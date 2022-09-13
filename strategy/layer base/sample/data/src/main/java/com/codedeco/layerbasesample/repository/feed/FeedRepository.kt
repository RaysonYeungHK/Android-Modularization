package com.codedeco.layerbasesample.repository.feed

interface FeedRepository {
    fun getFeed(): List<String>?
}