package com.codedeco.feature.authentication

import com.codedeco.framework.authentication.AuthenticationManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface AuthenticationManagerModule {
    @ViewModelScoped
    @Binds
    fun bindAuthenticationManager(manager: AuthenticationManagerImpl): AuthenticationManager
}