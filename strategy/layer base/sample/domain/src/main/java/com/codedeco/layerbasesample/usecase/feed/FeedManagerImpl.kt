package com.codedeco.layerbasesample.usecase.feed

import com.codedeco.layerbasesample.repository.feed.FeedRepository

class FeedManagerImpl: FeedManager {
    private lateinit var feedRepository: FeedRepository

    override fun getFeed(): List<String>? {
        /*
        // some sample logic
        if (!isNetworkConnected) {
            showConnectivityWarning()
            return null
        }
        return feedRepository.getFeed()
         */
        return null
    }
}