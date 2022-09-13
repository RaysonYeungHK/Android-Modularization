package com.codedeco.hybridsample.repository.feed

interface FeedRepository {
    fun getFeed(): List<String>?
}