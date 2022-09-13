package com.codedeco.layerbasesample.view.featureB

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.layerbasesample.viewmodel.featureB.FeatureBActivityViewModel

class FeatureBActivity : AppCompatActivity() {
    private lateinit var viewModel: FeatureBActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        // Interaction with view model
        findViewById<View>(R.id.login_button).setOnClickListener {
            viewModel.onLoginClick()
        }
         */
    }
}