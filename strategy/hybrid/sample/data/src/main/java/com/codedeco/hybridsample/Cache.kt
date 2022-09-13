package com.codedeco.hybridsample

import com.codedeco.hybridsample.entity.Profile

interface Cache {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}