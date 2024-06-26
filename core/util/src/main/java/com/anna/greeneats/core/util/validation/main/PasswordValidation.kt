package com.anna.greeneats.core.util.validation.main

import com.anna.greeneats.core.util.validation.error.Password
import com.anna.greeneats.core.util.validation.pattern.CustomPatterns

/**
Password field validation
 */
object PasswordValidations: Validation<Password> {
  // Minimum 8 characters, uppercase, lowercase, digits and a special character
  override fun validate(input: String): Password {
    val isEmpty = CustomPatterns.EMPTY.matcher(input).matches()
    val isTooShort = !CustomPatterns.MIN_PASSWORD_LENGTH.matcher(input).matches()
    val hasNoUppercase = !CustomPatterns.UPPERCASE.matcher(input).matches()
    val hasNoLowercase = !CustomPatterns.LOWERCASE.matcher(input).matches()
    val hasNoDigits = !CustomPatterns.DIGITS.matcher(input).matches()
    val hasNoSpecialChars = !CustomPatterns.SPECIAL_CHARS.matcher(input).matches()

    return when(true){
      isEmpty -> Password.REQUIRED
      isTooShort -> Password.TOO_SHORT
      hasNoUppercase -> Password.NO_UPPERCASE
      hasNoLowercase -> Password.NO_LOWERCASE
      hasNoDigits -> Password.NO_DIGITS
      hasNoSpecialChars -> Password.NO_SPECIAL_CHARS
      else -> Password.VALID_PASSWORD
    }
  }
}