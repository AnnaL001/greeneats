package com.anna.greeneats.core.ui.forms.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.theme.GreenEatsTheme

@Preview(showSystemUi = true, showBackground = true, group = "without icon")
@Composable
fun AppButtonWithoutIcon(){
  GreenEatsTheme{
    Column {
      GreenEatsButton(
        buttonText = "Click me!",
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_small_padding))
      )
    }
  }
}

@Preview  (showSystemUi = true, showBackground = true, group = "with icon")
@Composable
fun AppButtonWithIcon(){
  GreenEatsTheme{
    Column {
      GreenEatsButtonWithIcon(
        buttonText = "Click me!",
        modifier = Modifier.padding(dimensionResource(id = R.dimen.screen_medium_padding)),
        icon = R.drawable.bookmark_add,
        contentDesc = stringResource(id = R.string.bookmark_icon)
      )
    }
  }
}
