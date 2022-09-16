package com.codedeco.feature.activityresultsample

import com.codedeco.framework.navigation.Navigator
import com.codedeco.framework.navigation.NavigatorKey
import com.codedeco.framework.navigation.navigator.ActivityResultSampleNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ActivityResultSampleNavigatorModule {
    @Singleton
    @Binds
    @IntoMap
    @NavigatorKey(ActivityResultSampleNavigator::class)
    fun bindActivityResultSampleNavigator(navigator: ActivityResultSampleNavigatorImpl): Navigator
}