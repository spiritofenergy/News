package com.kodex.news.presentation.screen.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kodex.news.data.repository.AuthRepository
import com.kodex.news.presentation.screen.login.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {
  /*  var state by mutableStateOf(RegisterScreenState())
        private set*/
    private val _state = MutableStateFlow(RegisterScreenState())

    val state = _state.asStateFlow()


    fun onEvent(event: RegisterScreenEvent){
        when(event){
            is RegisterScreenEvent.UsernameUpdate -> onUsernameUpdated(newUsername = event.newUsername)
            is RegisterScreenEvent.EmailUpdate -> onEmailUpdated(newEmail = event.newEmail)
            is RegisterScreenEvent.PasswordUpdate -> onPasswordUpdated(newPassword = event.newPassword)
            is RegisterScreenEvent.RegisterBtnClicked -> register()

        }
    }

    private fun onUsernameUpdated(newUsername: String){
        _state.update { it.copy(username = newUsername) }
    }

    private fun onEmailUpdated(newEmail: String){
        _state.update { it.copy(email = newEmail) }
    }

    private fun onPasswordUpdated(newPassword: String){
        _state.update { it.copy(password = newPassword) }
    }

    private fun register() = viewModelScope.launch(Dispatchers.IO) {
        val username = state.value.username
        val email = state.value.email
        val password = state.value.password
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) return@launch

        val result = authRepository.register(username, email, password)
        this@RegisterScreenViewModel._state.update { it.copy(registerResult = result) }
    }

}