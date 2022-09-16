package com.codedeco.feature.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.feature.main.databinding.ActivityMainBinding
import com.codedeco.framework.navigation.navigator.MainNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.navigatorFactory.get(MainNavigator::class.java)
            ?.createFragment()
            ?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, this)
                    .commitAllowingStateLoss()
            }
    }
}