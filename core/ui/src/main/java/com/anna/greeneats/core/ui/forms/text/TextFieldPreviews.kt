package com.anna.greeneats.core.ui.forms.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.theme.GreenEatsTheme

/**====================================================================
 * Text field Previews
 * ===================================================================*/
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun GreenEatsFilledTextFieldPreview(){
  val input = remember { mutableStateOf("Anna") }

  GreenEatsTheme {
    Column {
      GreenEatsTextField(
        inputState = input,
        placeholder = stringResource(id = R.string.name_placeholder),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding))
      )
    }
  }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, group = "empty")
fun GreenEatsEmptyTextFieldPreview(){
  val input = remember { mutableStateOf("") }

  GreenEatsTheme {
    GreenEatsTextField(
      inputState = input,
      placeholder = stringResource(id = R.string.name_placeholder),
      modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
      isError = true,
      errorMessage = stringResource(id = R.string.name_required_error)
    )
  }
}