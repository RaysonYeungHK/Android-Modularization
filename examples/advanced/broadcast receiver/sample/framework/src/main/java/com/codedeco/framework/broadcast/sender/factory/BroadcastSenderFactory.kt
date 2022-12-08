package com.codedeco.framework.broadcast.sender.factory

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import com.codedeco.framework.broadcast.sender.BroadcastSender

interface BroadcastSenderFactory {
    @MainThread
    fun <T : BroadcastSender> get(modelClass: Class<T>): T?
}