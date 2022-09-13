package com.codedeco.feature.b

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureBActivity: AppCompatActivity() {
    private val viewModel by viewModels<FeatureBViewModel>()
}