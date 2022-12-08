package com.codedeco.framework.broadcast

import android.content.BroadcastReceiver
import android.content.IntentFilter
import javax.inject.Inject

class NullBroadcast @Inject constructor() : Broadcast() {
    override val receiver: BroadcastReceiver
        get() = throw IllegalAccessException()
    override val filter: IntentFilter
        get() = throw IllegalAccessException()
}