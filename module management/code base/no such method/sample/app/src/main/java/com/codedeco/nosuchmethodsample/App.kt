package com.codedeco.nosuchmethodsample

import android.app.Application
import com.codedeco.Foo

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // This cause NoSuchMethodError
        Foo().foo2()
    }
}