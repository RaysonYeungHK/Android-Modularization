package com.codedeco.hybridsample.repository.profile

import com.codedeco.hybridsample.entity.Profile

interface ProfileRepository {
    fun getProfile(): Profile?
}