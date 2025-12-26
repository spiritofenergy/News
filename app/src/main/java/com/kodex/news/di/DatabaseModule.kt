package com.kodex.news.di

import android.content.Context
import androidx.room.Room
import com.kodex.news.data.database.UserDatabase
import com.kodex.news.domain.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "userDatabase.db"
        ).build()
    }



@Provides
@Singleton
fun provideUserDao(userDatabase: UserDatabase): UserDao {
    return userDatabase.getUserDao()
}
    }
