package com.kodex.news.presentation.screen.register

import com.kodex.news.domain.util.Result

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