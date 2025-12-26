package com.kodex.news.presentation.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kodex.news.R
import com.kodex.news.presentation.navigation.Screen
import com.kodex.news.presentation.screen.state.LoginScreenEvent
import com.kodex.news.presentation.screen.state.LoginScreenState
import com.kodex.news.presentation.screen.state.RegisterScreenEvent
import com.kodex.news.presentation.screen.viewmodel.LoginScreenViewModel
import com.kodex.news.ui.component.StyleButton
import com.kodex.news.util.Result

@Composable
fun LoginScreen(
    onNavigateTo: (Screen) -> Unit = {},
) {
    val viewModel = hiltViewModel<LoginScreenViewModel>()
    val context = LocalContext.current
    LaunchedEffect(viewModel.state.loginResult) {
        viewModel.state.loginResult?.let { loginResult ->
            when(loginResult){
                is Result.Success<*> -> {
                    onNavigateTo(Screen.Main)
                }
                is Result.Failure<*> -> {
                    Toast.makeText(context, loginResult .msg, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
    LoginView (
            state = viewModel.state,
        onEvent = viewModel::onEvent,
        onNavigateTo = onNavigateTo
    )
}
    @Composable
    fun LoginView(
        state: LoginScreenState = LoginScreenState(),
        onEvent: (LoginScreenEvent)-> Unit = {},
        onNavigateTo: (Screen) -> Unit = {}
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 15.dp)
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "News app login image"
            )
            Spacer(modifier = Modifier.padding(20.dp))

            OutlinedTextField(
                value = state.email,
                shape = RoundedCornerShape(15.dp),
                onValueChange = {
                    onEvent(LoginScreenEvent.EmailUpdate(it))
                },
                leadingIcon = {
                    Icon(painter = rememberVectorPainter(image = Icons.Outlined.Email),
                        contentDescription = null)
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.enter_email))
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            OutlinedTextField(
                value = state.password,
                shape = RoundedCornerShape(15.dp),
                onValueChange = {
                    onEvent(LoginScreenEvent.PasswordUpdate(it))
                },
                leadingIcon = {
                    Icon(painter = rememberVectorPainter(image = Icons.Outlined.Person),
                        contentDescription = null)
                },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Text(text = stringResource(id = R.string.enter_password))
                }
            )
            Spacer(modifier = Modifier.padding(30.dp))

            StyleButton(
                onClick = { onEvent(LoginScreenEvent.LoginBtnClicked) },
                modifier = Modifier.padding(bottom = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.login)
                )
            }
            Text(text = stringResource(id = R.string.no_account_register),
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
                    .padding(top = 28.dp)
                    .clickable{
                        onNavigateTo(Screen.Register)
                    },

                )
        }
    }



@Composable
@Preview(showBackground = true)
fun Preview(){
    LoginScreen ()
}