package com.kodex.news.presentation.screen.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kodex.news.data.repository.AuthRepository
import com.kodex.news.presentation.screen.state.LoginScreenEvent
import com.kodex.news.presentation.screen.state.LoginScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    var state by mutableStateOf(LoginScreenState())
        private set

    fun onEvent(event: LoginScreenEvent) {
        when(event){
            is LoginScreenEvent.EmailUpdate -> this.state = state.copy(email = event.newEmail)
            is LoginScreenEvent.PasswordUpdate -> this.state = state.copy(password = event.newPassword)
            LoginScreenEvent.LoginBtnClicked -> login()
        }
    }
    private fun login() = viewModelScope.launch (Dispatchers.IO){
        val email = state.email
        val password = state.password
        if (email.isEmpty() || password.isEmpty()) return@launch
        val result = authRepository.login(email,password)
        this@LoginScreenViewModel.state = state.copy(loginResult = result)
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