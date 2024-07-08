package com.anna.greeneats.auth.common

import com.anna.greeneats.core.util.validation.error.ConfirmPassword
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

data class ConfirmPasswordErrorState(
  val isPasswordError: Boolean = false,
  val confirmPasswordValidation: ConfirmPassword = ConfirmPassword.INITIAL
)