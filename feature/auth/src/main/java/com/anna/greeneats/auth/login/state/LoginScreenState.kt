package com.anna.greeneats.auth.login.state

import com.anna.greeneats.auth.common.EmailErrorState
import com.anna.greeneats.auth.common.PasswordErrorState

data class LoginScreenState (
  val email: String = "",
  val password: String = "",
  val passwordHidden: Boolean = true,
  val emailErrorState: EmailErrorState = EmailErrorState(),
  val passwordErrorState: PasswordErrorState = PasswordErrorState(),
  val navigateToHome: Boolean = false,
  val loginInProgress: Boolean = false,
  val loginError: String = "",
  val isNotVerified: Boolean = false
)