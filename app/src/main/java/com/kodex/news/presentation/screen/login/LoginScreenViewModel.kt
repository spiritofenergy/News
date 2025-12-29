package com.kodex.news.presentation.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodex.news.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

 /*   var state by mutableStateOf(LoginScreenState())
        private set*/
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()


    fun onEvent(event: LoginScreenEvent) {
        when(event){
            is LoginScreenEvent.EmailUpdate -> onEmailUpdated(newEmail = event.newEmail)
            is LoginScreenEvent.PasswordUpdate -> onPasswordUpdated(newPassword = event.newPassword)
            LoginScreenEvent.LoginBtnClicked -> login()
        }
    }

    private fun onEmailUpdated(newEmail: String){
        _state.update { it.copy(email = newEmail) }
    }

    private fun onPasswordUpdated(newPassword: String){
        _state.update { it.copy(password = newPassword) }
    }

    private fun login() = viewModelScope.launch(Dispatchers.IO){
        val email = state.value.email
        val password = state.value.password
        if (email.isEmpty() || password.isEmpty()) return@launch
        val result = authRepository.login(email,password)
        this@LoginScreenViewModel._state.update { it.copy(loginResult = result) }
    // state.loginResult = result
    }



  /*  var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set


    fun updateEmail (email:String){
        this.email = email
    }

    fun updatePassword (password: String){
        this.password = password
    }*/
}