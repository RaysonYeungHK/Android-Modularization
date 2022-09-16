package com.codedeco.feature.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.feature.splash.databinding.ActivitySplashBinding
import com.codedeco.framework.navigation.navigator.MainNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<SplashActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        // Just want for 2 seconds and open MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            viewModel.navigatorFactory.get(MainNavigator::class.java)
                ?.createIntent(this@SplashActivity)
                ?.run {
                    startActivity(this@run)
                    finish()
                }
        }, 2000)
    }
}