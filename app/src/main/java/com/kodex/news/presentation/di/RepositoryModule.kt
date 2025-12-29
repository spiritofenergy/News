package com.kodex.news.presentation.di

import com.kodex.news.data.repository.AuthRepository
import com.kodex.news.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao): AuthRepository{
        return AuthRepository(userDao)
    }

}