package com.codedeco.framework.broadcast.sender

import android.content.Intent
import javax.inject.Inject

class NullBroadcastSender @Inject constructor() : BroadcastSender {
    init {
        throw IllegalAccessException("You should not access this class")
    }

    override fun createIntent(): Intent {
        throw IllegalAccessException("You should not access this class")
    }
}