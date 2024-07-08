package com.anna.greeneats.auth.login.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.anna.greeneats.auth.common.EmailErrorState
import com.anna.greeneats.auth.common.PasswordErrorState
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password
import com.anna.greeneats.core.util.validation.main.EmailValidations
import com.anna.greeneats.core.util.validation.main.PasswordValidations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor() : ViewModel() {
  private val _loginState = mutableStateOf(LoginScreenState())
  val loginState
    get() = _loginState as State<LoginScreenState>

  fun onEvents(events: LoginScreenEvents){
    when(events){
      is LoginScreenEvents.OnLogin -> {

      }

      is LoginScreenEvents.OnLoginValidation -> {
        performEmailValidation()
        performPasswordValidation()
      }


      is LoginScreenEvents.OnPasswordVisibilityToggle -> {
        _loginState.value = _loginState.value.copy(passwordHidden = !_loginState.value.passwordHidden)
      }

      is LoginScreenEvents.OnEmailChange -> {
        _loginState.value = _loginState.value.copy(email = events.email)
      }

      is LoginScreenEvents.OnPasswordChange -> {
        _loginState.value = _loginState.value.copy(password = events.password)
      }
    }
  }


  /** Perform email validation */
  private fun performEmailValidation() {
    val emailValidation = getEmailValidationResult(_loginState.value.email)
    val isInvalidEmail = emailValidation != Email.INITIAL && emailValidation != Email.VALID_EMAIL

    val emailErrorState = EmailErrorState(isInvalidEmail, emailValidation)

    _loginState.value = _loginState.value.copy(emailErrorState = emailErrorState)
  }

  /** Perform password validation */
  private fun performPasswordValidation() {
    val passwordValidation = getPasswordValidationResult(_loginState.value.password)
    val isValidPassword = passwordValidation != Password.INITIAL && passwordValidation != Password.VALID_PASSWORD

    val passwordErrorState = PasswordErrorState(isValidPassword, passwordValidation)

    _loginState.value = _loginState.value.copy(passwordErrorState = passwordErrorState)
  }

  /**
   * Get email validation results
   *
   * @param email Email input
   * @return Email validation results
   */
  private fun getEmailValidationResult(email: String): Email = EmailValidations.validate(email)

  /**
   * Get password validation results
   *
   * @param password Password input
   * @return Password validation results
   */
  private fun getPasswordValidationResult(password: String): Password =
      PasswordValidations.validate(password)
}
