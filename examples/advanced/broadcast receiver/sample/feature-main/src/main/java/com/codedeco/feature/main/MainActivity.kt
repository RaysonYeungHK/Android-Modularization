package com.codedeco.feature.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.framework.broadcast.listener.AuthenticationBroadcastListener
import com.codedeco.framework.broadcast.register.BroadcastRegister
import com.codedeco.framework.broadcast.sender.AuthenticationBroadcastSender
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var broadcastRegister: BroadcastRegister

    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Attach the broadcast register to activity
        broadcastRegister.attach(this)

        // Register broadcast listener
        broadcastRegister.register(viewModel)
    }

    override fun onResume() {
        super.onResume()

        // Testing
        viewModel.onLoginClick()
        viewModel.onAddNotificationClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        // We don't need to detach activity since BroadcastRegister NEVER keep the strong reference of activity
    }
}