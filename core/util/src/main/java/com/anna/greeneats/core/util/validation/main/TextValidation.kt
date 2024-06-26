package com.anna.greeneats.core.util.validation.main

import com.anna.greeneats.core.util.validation.error.Name
import com.anna.greeneats.core.util.validation.pattern.CustomPatterns

/**
 * Text field validation
 */
object TextValidations: Validation<Name> {
  override fun validate(input: String): Name {
    val isEmpty = CustomPatterns.EMPTY.matcher(input).matches()
    val hasNoDigits = !CustomPatterns.DIGITS.matcher(input).matches()

    return when(true){
      isEmpty -> Name.REQUIRED
      hasNoDigits -> Name.HAS_DIGITS
      else -> Name.VALID_NAME
    }
  }

}