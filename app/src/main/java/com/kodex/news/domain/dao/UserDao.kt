package com.kodex.news.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kodex.news.domain.entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)

    @Delete
   suspend fun deleteUser(user: User)

    @Query("SELECT * FROM user WHERE email=:email")
   suspend fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM user WHERE email=:email and password=:password")
   suspend fun login(email: String, password: String): User?
}