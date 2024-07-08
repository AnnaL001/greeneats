package com.anna.greeneats.auth.signup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.anna.greeneats.auth.login.state.LoginScreenEvents
import com.anna.greeneats.auth.login.ui.LoginScreenUI
import com.anna.greeneats.auth.signup.state.SignupScreenEvents
import com.anna.greeneats.auth.signup.state.SignupScreenViewModel
import com.anna.greeneats.core.ui.forms.button.GreenEatsButton
import com.anna.greeneats.core.ui.layout.card.GreenEatsCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SignUpScreenInt(
  onNavigateToLogin: () -> Unit = {},
  signupViewModel: SignupScreenViewModel = viewModel()) {
  Column(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.surface)) {
    val signUpState = signupViewModel.signupState.value

    SignupScreenUI(
      signupScreenState = signUpState,
      onLoginNavigation = onNavigateToLogin,
      onPasswordVisibilityToggle = {
        signupViewModel.onEvents(SignupScreenEvents.OnPasswordVisibilityToggle)
      },
      onConfirmPasswordVisibilityToggle = {
        signupViewModel.onEvents(SignupScreenEvents.OnConfirmPasswordVisibilityToggle)
      },
      onSignupValidation = {
        signupViewModel.onEvents(SignupScreenEvents.OnSignupValidation)
      },
      onEmailChange = { email ->
        signupViewModel.onEvents(SignupScreenEvents.OnEmailChange(email)) },
      onPasswordChange = { password ->
        signupViewModel.onEvents(SignupScreenEvents.OnPasswordChange(password))
      },
      onConfirmPasswordChange = {
        confirmPassword -> signupViewModel.onEvents(SignupScreenEvents.OnConfirmPasswordChange(confirmPassword))
      },
      onSignup = {
        signupViewModel.onEvents(SignupScreenEvents.OnSignup)
      }
    )
  }
}

