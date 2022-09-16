package com.codedeco.feature.subfragment

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.AndroidViewModel
import com.codedeco.framework.navigation.factory.NavigatorFactory
import com.codedeco.framework.navigation.navigator.SubFragmentNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SubFragmentViewModel @Inject constructor(
    application: Application,
    val navigatorFactory: NavigatorFactory
) : AndroidViewModel(application) {
    var count: Int = Int.MIN_VALUE
        private set

    fun init(arguments: Bundle?) {
        navigatorFactory.get(SubFragmentNavigator::class.java)
            ?.getParam(arguments)
            ?.run {
                this@SubFragmentViewModel.count = this@run.count
            }
    }
}