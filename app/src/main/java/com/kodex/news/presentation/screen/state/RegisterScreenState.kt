package com.kodex.news.presentation.screen.state

import com.kodex.news.util.Result

sealed class RegisterScreenEvent{
    data class UsernameUpdate(val newUsername: String): RegisterScreenEvent()
    data class EmailUpdate(val newEmail: String): RegisterScreenEvent()
    data class PasswordUpdate(val newPassword: String): RegisterScreenEvent()
    data object RegisterBtnClicked: RegisterScreenEvent()
}

data class RegisterScreenState (
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val registerResult: Result? = null
)