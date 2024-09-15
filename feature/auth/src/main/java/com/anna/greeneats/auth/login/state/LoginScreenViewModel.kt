package com.anna.greeneats.auth.login.state

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anna.greeneats.auth.common.EmailErrorState
import com.anna.greeneats.auth.common.PasswordErrorState
import com.anna.greeneats.core.model.resource.Resource
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password
import com.anna.greeneats.core.util.validation.main.EmailValidations
import com.anna.greeneats.core.util.validation.main.PasswordValidations
import com.anna.greeneats.data.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
  private val authRepository: AuthRepository
) : ViewModel() {
  private val _loginState = mutableStateOf(LoginScreenState())
  val loginState
    get() = _loginState as State<LoginScreenState>

  fun onEvents(events: LoginScreenEvents){
    when(events){
      is LoginScreenEvents.OnLogin -> {
        performLogin()
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

      is LoginScreenEvents.OnGoogleLogin -> {
        performGoogleLogin(events.context)
      }
    }
  }

  /**
   * Trigger verification error
   */
  private fun triggerVerificationError() {
    _loginState.value = _loginState.value.copy(isNotVerified = true)
  }

  /**
   * Trigger home navigation
   */
  private fun triggerHomeNavigation(){
    _loginState.value = _loginState.value.copy(navigateToHome = true)
  }

  /**
   * Perform login
   */
  private fun performLogin(){
    _loginState.value = _loginState.value.copy(loginInProgress = true)

    viewModelScope.launch {
      val response = authRepository.loginWithEmail(_loginState.value.email, _loginState.value.password)

      when(response){
        is Resource.Success -> {
          stopLoader()

          if(authRepository.isVerified == true){
            triggerHomeNavigation()
            return@launch
          }

          authRepository.logout()
          triggerVerificationError()
        }

        is Resource.Failure -> {
          stopLoader()
          _loginState.value = _loginState.value.copy(loginError = response.exception.message.toString())
        }
      }
    }
  }

  /**
   * Perform google login
   */
  fun performGoogleLogin(context: Context){
    viewModelScope.launch {
      when(val response = authRepository.loginWithGoogle(context)){
        is Resource.Success -> {
          stopLoader()
          triggerHomeNavigation()
        }

        is Resource.Failure -> {
          stopLoader()
          _loginState.value = _loginState.value.copy(loginError = response.exception.message.toString())
        }
      }
    }
  }

  /**
   * Initiate loader
   */
  private fun stopLoader(){
    _loginState.value = _loginState.value.copy(loginInProgress = false);
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
