package com.anna.greeneats.auth.signup.state

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anna.greeneats.auth.common.ConfirmPasswordErrorState
import com.anna.greeneats.auth.common.EmailErrorState
import com.anna.greeneats.auth.common.PasswordErrorState
import com.anna.greeneats.core.util.validation.error.ConfirmPassword
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password
import com.anna.greeneats.core.util.validation.main.ConfirmPasswordValidations
import com.anna.greeneats.core.util.validation.main.EmailValidations
import com.anna.greeneats.core.util.validation.main.PasswordValidations
import com.anna.greeneats.data.auth.AuthRepository
import com.anna.greeneats.model.main.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupScreenViewModel @Inject constructor(
  private val authRepository: AuthRepository
) : ViewModel() {
  private val _signupState = mutableStateOf(SignupScreenState())
  val signupState
    get() = _signupState as State<SignupScreenState>

  fun onEvents(events: SignupScreenEvents){
    when(events){
      is SignupScreenEvents.OnSignup -> {
        performSignUp()
      }

      is SignupScreenEvents.OnSignupValidation -> {
        performEmailValidation()
        performPasswordValidation()
        performConfirmPasswordValidation()
      }


      is SignupScreenEvents.OnPasswordVisibilityToggle -> {
        _signupState.value = _signupState.value.copy(passwordHidden = !_signupState.value.passwordHidden)
      }

      is SignupScreenEvents.OnConfirmPasswordVisibilityToggle -> {
        _signupState.value = _signupState.value.copy(confirmPasswordHidden = !_signupState.value.confirmPasswordHidden)
      }

      is SignupScreenEvents.OnEmailChange -> {
        _signupState.value = _signupState.value.copy(email = events.email)
      }

      is SignupScreenEvents.OnPasswordChange -> {
        _signupState.value = _signupState.value.copy(password = events.password)
      }

      is SignupScreenEvents.OnConfirmPasswordChange -> {
        _signupState.value = _signupState.value.copy(confirmPassword = events.confirmPassword)
      }

    }
  }

  /**
   * Perform sign up
   */
  private fun performSignUp(){
    _signupState.value = _signupState.value.copy(signupInProgress = true)

    viewModelScope.launch {
      val response = authRepository.signupWithEmail(_signupState.value.email, _signupState.value.password)
      when(response){
        is Resource.Success -> {
          stopLoader()
          _signupState.value = _signupState.value.copy(navigateToLogin = true)
        }

        is Resource.Failure -> {
          stopLoader()
          _signupState.value = _signupState.value.copy(signUpError = response.exception.message.toString())
        }
      }
    }
  }

  /**
   * Initiate loader
   */
  private fun stopLoader(){
    _signupState.value = _signupState.value.copy(signupInProgress = false);
  }

  /** Perform email validation */
  private fun performEmailValidation() {
    val emailValidation = getEmailValidationResult(_signupState.value.email)
    val isInvalidEmail = emailValidation != Email.INITIAL && emailValidation != Email.VALID_EMAIL

    val emailErrorState = EmailErrorState(isInvalidEmail, emailValidation)

    _signupState.value = _signupState.value.copy(emailErrorState = emailErrorState)
  }

  /** Perform password validation */
  private fun performPasswordValidation() {
    val passwordValidation = getPasswordValidationResult(_signupState.value.password)
    val isValidPassword = passwordValidation != Password.INITIAL && passwordValidation != Password.VALID_PASSWORD

    val passwordErrorState = PasswordErrorState(isValidPassword,
      passwordValidation)

    _signupState.value = _signupState.value.copy(passwordErrorState = passwordErrorState)
  }

  /** Perform password validation */
  private fun performConfirmPasswordValidation() {
    val confirmPasswordValidation = getConfirmPasswordValidationResult(_signupState.value.password, _signupState.value.confirmPassword)
    val isValidConfirmPassword = confirmPasswordValidation != ConfirmPassword.INITIAL && confirmPasswordValidation != ConfirmPassword.VALID_CONFIRM_PASSWORD

    val confirmPasswordErrorState = ConfirmPasswordErrorState(isValidConfirmPassword,
      confirmPasswordValidation)

    _signupState.value = _signupState.value.copy(confirmPasswordErrorState = confirmPasswordErrorState)
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

  /**
   * Get confirm password validation result
   * @param password Password input
   * @param confirmPassword Confirm password input
   * @return Confirm password validation result
   */
  private fun getConfirmPasswordValidationResult(password: String, confirmPassword: String): ConfirmPassword =
    ConfirmPasswordValidations.validate(password, confirmPassword)
}