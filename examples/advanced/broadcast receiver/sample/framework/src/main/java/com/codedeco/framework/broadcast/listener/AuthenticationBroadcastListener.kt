package com.codedeco.framework.broadcast.listener

import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender

interface AuthenticationBroadcastListener : BroadcastListener {
    fun onAuthenticationChange(data: AuthenticationBroadcastSender.Data)
}