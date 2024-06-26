package com.anna.greeneats.core.util.validation.main

import android.util.Patterns
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.pattern.CustomPatterns

/**
 * Email field validation
 */
object EmailValidations: Validation<Email> {
  override fun validate(input: String): Email {
    val isEmpty = CustomPatterns.EMPTY.matcher(input).matches()
    val hasUppercase = CustomPatterns.UPPERCASE.matcher(input).matches()
    val isNotValid = !Patterns.EMAIL_ADDRESS.matcher(input).matches()

    return when(true){
      isEmpty -> Email.REQUIRED
      hasUppercase -> Email.NO_LOWERCASE
      isNotValid -> Email.INVALID_PATTERN
      else -> Email.VALID_EMAIL
    }
  }

}