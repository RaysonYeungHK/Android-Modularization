package com.codedeco.share.serviceprovider

import javax.inject.Inject

class NullServiceProvider @Inject constructor() : ServiceProvider {
    init {
        throw IllegalAccessError("You should never access this class, this is used to avoid compile error")
    }
}