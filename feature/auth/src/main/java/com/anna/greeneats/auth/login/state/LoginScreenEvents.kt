package com.anna.greeneats.auth.login.state

import android.content.Context

sealed class LoginScreenEvents {
  data object OnLogin : LoginScreenEvents()

  data class OnGoogleLogin(val context: Context): LoginScreenEvents()

  data object OnLoginValidation: LoginScreenEvents()

  data object OnPasswordVisibilityToggle: LoginScreenEvents()

  data class OnEmailChange(val email: String): LoginScreenEvents()

  data class OnPasswordChange(val password: String): LoginScreenEvents()
}