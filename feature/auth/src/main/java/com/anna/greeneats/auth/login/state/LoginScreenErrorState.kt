package com.anna.greeneats.auth.login.state

import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password

data class  EmailErrorState(
  val isEmailError: Boolean = false,
  val emailValidation: Email = Email.INITIAL
)

data class PasswordErrorState(
  val isPasswordError: Boolean = false,
  val passwordValidation: Password = Password.INITIAL
)