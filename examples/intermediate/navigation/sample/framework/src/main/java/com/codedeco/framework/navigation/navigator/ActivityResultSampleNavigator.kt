package com.codedeco.framework.navigation.navigator

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.codedeco.framework.navigation.Navigator
import kotlinx.parcelize.Parcelize

interface ActivityResultSampleNavigator : Navigator {
    fun createIntent(context: Context): Intent

    fun createFragment(): Fragment

    fun createResult(result: Result): Intent

    fun getResult(intent: Intent?): Result?

    @Parcelize
    data class Result(
        val isSuccess: Boolean
    ) : Parcelable
}