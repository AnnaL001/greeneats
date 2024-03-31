package com.anna.greeneats.core.ui.forms.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

/**
 * Represents options for keyboard inputs
 */
enum class KeyOptions{
  TEXT_INPUT,
  EMAIL_INPUT,
  PASSWORD_INPUT
}

/**
 * Determines keyboard type to be returned based on KeyOptions instance provided
 * @param keyOptions KeyOptions instance
 * @return Keyboard type
 */
fun getKeyboard(keyOptions: KeyOptions): KeyboardOptions {
  return KeyboardOptions(
    keyboardType = when(keyOptions){
      KeyOptions.TEXT_INPUT -> KeyboardType.Text
      KeyOptions.EMAIL_INPUT -> KeyboardType.Email
      KeyOptions.PASSWORD_INPUT -> KeyboardType.Password
    },
    imeAction = ImeAction.Done
  )
}



