package com.codedeco.featurebasesample.feature.a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FeatureAActivity : AppCompatActivity() {
    private lateinit var viewModel: FeatureAActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        // Interaction with view model
        findViewById<View>(R.id.login_button).setOnClickListener {
            viewModel.onLoginClick()
        }
         */

        /*
        // TODO, it doesn't work since each feature doesn't know each other
        // Interaction with other features
        val intent = Intent(this, FeatureBActivity::class.java)
        startActivity(intent)
         */
    }
}