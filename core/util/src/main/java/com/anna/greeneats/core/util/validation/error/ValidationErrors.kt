package com.anna.greeneats.core.util.validation.error

/**
 * Text validation results
 */
enum class Name{
  INITIAL,
  REQUIRED,
  HAS_DIGITS,
  VALID_NAME
}

/**
 * Email validation results
 */
enum class Email {
  INITIAL,
  REQUIRED,
  NO_LOWERCASE,
  INVALID_PATTERN,
  VALID_EMAIL
}

/**
 * Password validation results
 */
enum class Password {
  INITIAL,
  REQUIRED,
  TOO_SHORT,
  NO_UPPERCASE,
  NO_LOWERCASE,
  NO_DIGITS,
  NO_SPECIAL_CHARS,
  VALID_PASSWORD
}

/**
 * Confirm password validation results
 */
enum class ConfirmPassword{
  INITIAL,
  REQUIRED,
  MATCHES_PASSWORD,
  VALID_CONFIRM_PASSWORD
}