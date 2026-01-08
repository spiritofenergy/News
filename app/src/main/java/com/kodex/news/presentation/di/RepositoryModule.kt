package com.kodex.news.presentation.di

import android.content.Context
import com.kodex.news.data.repository.AuthRepository
import com.kodex.news.data.repository.LocalAuthManager
import com.kodex.news.data.repository.NewsRepository
import com.kodex.news.domain.dao.UserDao
import com.kodex.news.presentation.ui.component.NewsItemPreview
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    @Singleton
    fun provideLocalAuthManager(@ApplicationContext context: Context): LocalAuthManager {
        return LocalAuthManager(context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDao: UserDao, localAuthManager: LocalAuthManager ): AuthRepository {
        return AuthRepository(userDao, localAuthManager)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(): NewsRepository{
        return NewsRepository()
    }


}