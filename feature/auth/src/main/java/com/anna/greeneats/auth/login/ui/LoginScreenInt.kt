package com.anna.greeneats.auth.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anna.greeneats.auth.login.state.LoginScreenEvents
import com.anna.greeneats.auth.login.state.LoginScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LoginScreenInt(
    onNavigateToSignup: () -> Unit = {},
    onNavigateToHome: () -> Unit = {},
    loginModel: LoginScreenViewModel = viewModel()
) {
  Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface)) {
    val loginState = loginModel.loginState.value

    LoginScreenUI(
      loginState = loginState,
      onSignUpNavigation = onNavigateToSignup,
      onPasswordVisibilityToggle = {
         loginModel.onEvents(LoginScreenEvents.OnPasswordVisibilityToggle)
      },
      onLoginValidation = {
        loginModel.onEvents(LoginScreenEvents.OnLoginValidation)
      },
      onEmailChange = { email ->
        loginModel.onEvents(LoginScreenEvents.OnEmailChange(email))
      },
      onPasswordChange = { password ->
        loginModel.onEvents(LoginScreenEvents.OnPasswordChange(password))
      },
      onNavigateToHome = onNavigateToHome,
      onLogin = { loginModel.onEvents(LoginScreenEvents.OnLogin)})
  }
}
