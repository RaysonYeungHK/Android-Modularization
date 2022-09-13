package com.codedeco.featurebasesample.core

import kotlin.random.Random

// Implementation that NOT related to Android
object StringUtil {
    fun randomChar(): Char {
        return Random.nextInt().toChar()
    }
}