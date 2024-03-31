package com.anna.greeneats.core.ui.forms.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.forms.common.ErrorTrailingIcon
import com.anna.greeneats.core.ui.forms.common.GreenEatsFieldError
import com.anna.greeneats.core.ui.forms.common.KeyOptions
import com.anna.greeneats.core.ui.forms.common.fieldColorScheme
import com.anna.greeneats.core.ui.forms.common.getKeyboard
import com.anna.greeneats.core.ui.forms.common.greenEatsField

/**
 * Normal text field
 * @param inputState Field state
 * @param placeholder Text to be displayed when no value is present
 * @param modifier Modifier instance to add styling
 * @param isError Whether field validation has failed
 * @param errorMessage Error message to be displayed
 * @param onDone Function/method to run when field value has been input
 */
@Composable
fun GreenEatsTextField(
  inputState: MutableState<String>,
  placeholder: String,
  modifier: Modifier,
  isError: Boolean = false,
  errorMessage: String = "",
  onDone: (KeyboardActionScope.() -> Unit) ?= null,
){
  val keyboardController = LocalSoftwareKeyboardController.current

  Column {
    OutlinedTextField(
      value = inputState.value,
      onValueChange = { newValue ->
        inputState.value = newValue
      },
      modifier = Modifier.greenEatsField(isError, errorMessage, modifier),
      singleLine = true,
      textStyle = MaterialTheme.typography.bodyMedium,
      isError = isError,
      placeholder = { Text(text = placeholder) },
      trailingIcon = { if(isError) ErrorTrailingIcon() },
      colors = fieldColorScheme(),
      keyboardOptions = getKeyboard(KeyOptions.TEXT_INPUT),
      keyboardActions = KeyboardActions(
        onDone = {
          if(onDone is (KeyboardActionScope.() -> Unit)){
            onDone.invoke(this)
          } else {
            keyboardController?.hide()
          }
        }
      )
    )

    if (isError && errorMessage.isNotBlank()){
      GreenEatsFieldError(modifier = Modifier.padding(start = dimensionResource(id = R.dimen.screen_xlarge_padding)), errorMessage = errorMessage)
    }
  }
}
