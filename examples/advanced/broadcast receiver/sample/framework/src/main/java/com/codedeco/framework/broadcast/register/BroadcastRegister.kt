package com.codedeco.framework.broadcast.register

import androidx.appcompat.app.AppCompatActivity
import com.codedeco.framework.broadcast.listener.BroadcastListener

interface BroadcastRegister {
    // Attach to activity that listening any broadcast
    fun attach(activity: AppCompatActivity)

    // Add listener for broacast event handling
    fun register(behaviour: BroadcastListener)

    // Remove listener for broacast event handling
    fun unregister(behaviour: BroadcastListener)
}