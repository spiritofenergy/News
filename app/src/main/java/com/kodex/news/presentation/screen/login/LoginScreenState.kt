package com.kodex.news.presentation.screen.login

import com.kodex.news.domain.util.Result

sealed class LoginScreenEvent{
    data class EmailUpdate(val newEmail: String): LoginScreenEvent()
    data class PasswordUpdate(val newPassword: String): LoginScreenEvent()
    data object LoginBtnClicked: LoginScreenEvent()
}

data class LoginScreenState (
    val email: String = "",
    val password: String = "",
    var loginResult: Result? = null
){

}