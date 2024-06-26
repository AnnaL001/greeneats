package com.anna.greeneats.core.util.validation.pattern

import java.util.regex.Pattern

object CustomPatterns {
  val EMPTY: Pattern = Pattern.compile("^$")
  val LOWERCASE: Pattern = Pattern.compile("^.*[a-z].*$")
  val UPPERCASE: Pattern = Pattern.compile("^.*[A-Z].*$")
  val DIGITS: Pattern = Pattern.compile("^.*[0-9].*$")
  val SPECIAL_CHARS: Pattern = Pattern.compile("^.*[^a-zA-Z0-9\\s].*$")
  val MIN_PASSWORD_LENGTH: Pattern = Pattern.compile(".{8,}")
}