package com.codedeco.layerbasesample.view.featureA

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.layerbasesample.viewmodel.featureA.FeatureAActivityViewModel

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
        // Interaction with other features
        val intent = Intent(this, FeatureBActivity::class.java)
        startActivity(intent)
         */
    }
}