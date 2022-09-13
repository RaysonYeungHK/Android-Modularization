package com.codedeco.feature.a

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeatureAActivity: AppCompatActivity() {
    private val viewModel by viewModels<FeatureAViewModel>()
}