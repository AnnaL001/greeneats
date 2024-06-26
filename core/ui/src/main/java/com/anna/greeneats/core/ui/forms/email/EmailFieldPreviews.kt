package com.anna.greeneats.core.ui.forms.email

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

/**
 * ====================================================================
 * Email field previews
 * ===================================================================
 */
@Composable
@Preview(showBackground = true, showSystemUi = true, group = "filled")
fun GreenEatsFilledEmailFieldPreview() {
  GreenEatsTheme {
    Column {
      GreenEatsEmailField(
          inputState = "anna@gmail.com",
          placeholder = stringResource(id = R.string.email_placeholder),
          modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)))
    }
  }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, group = "empty")
fun GreenEatsEmptyEmailFieldPreview() {
  GreenEatsTheme {
    val errorMessage = stringResource(id = R.string.email_required_error)

    GreenEatsEmailField(
        inputState = "",
        placeholder = stringResource(id = R.string.email_placeholder),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        isError = true,
        errorMessage = errorMessage)
  }
}
