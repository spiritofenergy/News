package com.kodex.news.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kodex.news.domain.dao.UserDao
import com.kodex.news.domain.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
}