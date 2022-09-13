package com.codedeco.hybridsample

import com.codedeco.hybridsample.entity.Profile

interface Api {
    fun getFeed(): List<String>?
    fun getProfile(): Profile?
}