package com.codedeco.framework.navigation

import javax.inject.Inject

class NullNavigator @Inject constructor() : Navigator {
    init {
        throw IllegalAccessException("You should not access this class")
    }
}