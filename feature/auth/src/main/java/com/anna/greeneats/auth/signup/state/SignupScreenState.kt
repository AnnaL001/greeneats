package com.anna.greeneats.auth.signup.state

import com.anna.greeneats.auth.common.ConfirmPasswordErrorState
import com.anna.greeneats.auth.common.EmailErrorState
import com.anna.greeneats.auth.common.PasswordErrorState

data class SignupScreenState(
  val email: String = "",
  val password: String = "",
  val confirmPassword: String = "",
  val passwordHidden: Boolean = true,
  val confirmPasswordHidden: Boolean = true,
  val emailErrorState: EmailErrorState = EmailErrorState(),
  val passwordErrorState: PasswordErrorState = PasswordErrorState(),
  val confirmPasswordErrorState: ConfirmPasswordErrorState = ConfirmPasswordErrorState(),
  val navigateToLogin: Boolean = false,
  val signupInProgress: Boolean = false,
  val signUpError: String = ""
)
