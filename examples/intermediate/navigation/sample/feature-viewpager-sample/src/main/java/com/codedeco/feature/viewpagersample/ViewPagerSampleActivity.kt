package com.codedeco.feature.viewpagersample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.feature.viewpagersample.databinding.ActivityViewPagerSampleBinding
import com.codedeco.framework.navigation.navigator.ViewPagerSampleNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerSampleActivity : AppCompatActivity() {
    private val binding by lazy { ActivityViewPagerSampleBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<ViewPagerSampleActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.navigatorFactory.get(ViewPagerSampleNavigator::class.java)
            ?.createFragment()
            ?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, this)
                    .commitAllowingStateLoss()
            }
    }
}