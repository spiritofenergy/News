package com.kodex.news.data.repository

import android.util.Log
import com.kodex.news.domain.dao.UserDao
import com.kodex.news.domain.entity.User
import javax.inject.Inject
import com.kodex.news.domain.util.Result
import java.util.UUID

class AuthRepository @Inject constructor(
    private val userDao: UserDao,
    private val localAuthManager: LocalAuthManager,
) {
    suspend fun login (email: String, password: String): Result{
        val loginUser = userDao.login(email, password)
        val result = if (loginUser == null) Result.Failure<Unit>("Login failed")
        else {
            localAuthManager.rememberAuth(loginUser.id)
            Result.Success<Unit>("Successfully logged in")
        }

        return result
    }

   suspend fun register(username: String, email: String, password: String) : Result{
        if (userDao.getUserByEmail(email) != null)
           // Log.d("MyLog", email.toString())
            return Result.Failure<Unit>("User with this email already exists")

        val user = User(
            id = UUID.randomUUID().toString(),
            username = username,
            email = email,
            password = password
        )
        userDao.addUser(user)
        localAuthManager.rememberAuth(user.id)
        return Result.Success<Unit>("Successfully registered")
    }
}