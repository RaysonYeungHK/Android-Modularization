package com.codedeco.framework.application.lifecycle

object ApplicationLifeCycle {
    sealed class Event {
        object OnCreate : Event()

        object OnTerminate : Event()
    }
}