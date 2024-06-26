package com.anna.greeneats.auth.login.state

data class LoginScreenState (
  val email: String = "",
  val password: String = "",
  val passwordHidden: Boolean = true,
  val emailErrorState: EmailErrorState = EmailErrorState(),
  val passwordErrorState: PasswordErrorState = PasswordErrorState(),
  val navigateToHome: Boolean = false
)