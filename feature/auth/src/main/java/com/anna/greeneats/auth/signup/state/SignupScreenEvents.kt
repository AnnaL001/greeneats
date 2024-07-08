package com.anna.greeneats.auth.signup.state

sealed class SignupScreenEvents {
  data object OnSignup : SignupScreenEvents()

  data object OnSignupValidation: SignupScreenEvents()

  data object OnPasswordVisibilityToggle: SignupScreenEvents()

  data object OnConfirmPasswordVisibilityToggle: SignupScreenEvents()

  data class OnEmailChange(val email: String): SignupScreenEvents()

  data class OnPasswordChange(val password: String): SignupScreenEvents()

  data class  OnConfirmPasswordChange(val confirmPassword: String): SignupScreenEvents()
}