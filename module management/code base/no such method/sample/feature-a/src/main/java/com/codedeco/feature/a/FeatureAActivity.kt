package com.codedeco.feature.a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codedeco.Foo

class FeatureAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This doesn't cause NoSuchMethodError
        Foo().foo()
    }
}