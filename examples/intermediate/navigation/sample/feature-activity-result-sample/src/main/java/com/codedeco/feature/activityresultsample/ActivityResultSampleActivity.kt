package com.codedeco.feature.activityresultsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.feature.activityresultsample.databinding.ActivityActivityResultSampleBinding
import com.codedeco.framework.navigation.navigator.ActivityResultSampleNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityResultSampleActivity : AppCompatActivity() {
    private val binding by lazy { ActivityActivityResultSampleBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<ActivityResultSampleActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.navigatorFactory.get(ActivityResultSampleNavigator::class.java)
            ?.createFragment()
            ?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, this)
                    .commitAllowingStateLoss()
            }
    }
}