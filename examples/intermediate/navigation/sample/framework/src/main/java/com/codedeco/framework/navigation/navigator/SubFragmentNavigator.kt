package com.codedeco.framework.navigation.navigator

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.Navigator
import kotlinx.parcelize.Parcelize

interface SubFragmentNavigator : Navigator {
    fun createFragment(param: Param): Fragment

    fun getParam(bundle: Bundle?): Param?

    @Parcelize
    data class Param(
        val count: Int
    ) : Parcelable
}