package com.codedeco.framework.broadcast

import androidx.annotation.MainThread

interface BroadcastFactory {
    @MainThread
    fun <T : Broadcast> get(modelClass: Class<T>): T?

    @MainThread
    fun getBroadcasts(): List<Broadcast>
}