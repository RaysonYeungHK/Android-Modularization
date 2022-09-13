package com.codedeco.hybridsample.framework

import android.content.Context
import android.content.pm.ApplicationInfo

// Implementation that related to Android
object AndroidUtil {
    fun isDebuggable(context: Context): Boolean {
        return context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0
    }
}