package com.anna.greeneats.auth.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.util.validation.error.ConfirmPassword
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password
import timber.log.Timber

/**
 * Email validation messages options
 */
@Composable
fun emailValidationMsg(errorType: Email): String{
  return when(errorType){
    Email.INITIAL -> ""
    Email.REQUIRED -> stringResource(id = R.string.email_required_error)
    Email.INVALID_PATTERN -> stringResource(id = R.string.email_invalid_error)
    Email.NO_LOWERCASE -> stringResource(id = R.string.email_lowercase_error)
    Email.VALID_EMAIL -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Email validation successful")
      ""
    }
  }
}

/**
 * Password validation message options
 */
@Composable
fun passwordValidationMsg(errorType: Password): String{
  return when(errorType){
    Password.INITIAL -> ""
    Password.REQUIRED -> stringResource(id = R.string.password_required_error)
    Password.TOO_SHORT -> stringResource(id = R.string.password_short_error)
    Password.NO_UPPERCASE -> stringResource(id = R.string.password_no_uppercase_error)
    Password.NO_LOWERCASE -> stringResource(id = R.string.password_no_lowercase_error)
    Password.NO_DIGITS -> stringResource(id = R.string.password_no_digit_error)
    Password.NO_SPECIAL_CHARS -> stringResource(id = R.string.password_no_special_chars_error)
    Password.VALID_PASSWORD -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Password validation successful")
      ""
    }
  }
}

/**
 * Confirm password validation messages
 */
@Composable
fun confirmPasswordValidationMsg(errorType: ConfirmPassword): String{
  return when(errorType){
    ConfirmPassword.INITIAL -> ""
    ConfirmPassword.REQUIRED -> stringResource(id = R.string.confirm_password_required_error)
    ConfirmPassword.MATCHES_PASSWORD -> stringResource(id = R.string.confirm_password_match_error)
    ConfirmPassword.VALID_CONFIRM_PASSWORD -> {
      Timber.d("\uD83D\uDE03️SUCCESS: Confirm Password validation successful")
      ""
    }
  }
}