package com.anna.greeneats.core.ui.forms.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.anna.greeneats.core.ui.R

/**
 * App button used across the app
 * @param buttonText Text displayed within the button
 * @param modifier Modifier instance to add styling
 * @param onClick Function/method to be performed when button is clicked
 */
@Composable
fun GreenEatsButton(
  buttonText: String,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {}
){
    Button(
      onClick = onClick,
      modifier = modifier.greenEatsButton(modifier, dimensionResource(id = R.dimen.button_size)),
      colors = buttonColorScheme(),
      enabled = true ) {
      Text(
        text = buttonText,
        style = MaterialTheme.typography.displayMedium
      )
    }
}

/**
 * App button used across the app
 * @param buttonText Text displayed within the button
 * @param icon Icon to be displayed within the button
 * @param modifier Modifier instance to add styling
 * @param onClick Function/method to be performed when button is clicked
 * @param contentDesc Icon's content description
 */
@Composable
fun GreenEatsButtonWithIcon(
  buttonText: String,
  icon: CustomIcon,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {},
  contentDesc: String = "",
  customButtonColor: CustomButtonColor?=null
){
    Row(
      modifier = Modifier.greenEatsButtonWithIcon(modifier, dimensionResource(id = R.dimen.button_size), onClick, customButtonColor)
    ) {
      Image(
        contentScale = ContentScale.FillBounds,
        painter = painterResource(id = icon.image),
        contentDescription = contentDesc,
        modifier = Modifier.iconSizing(modifier, icon.size))
      Spacer(modifier = Modifier.spacing(modifier, dimensionResource(id = R.dimen.button_icon_spacing)))
      Text(
        text = buttonText,
        style = MaterialTheme.typography.displayMedium,
        color = customButtonColor?.contentColor ?: MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.medium_medium_large_padding))
      )
      Spacer(modifier = Modifier.spacing(modifier, dimensionResource(id = R.dimen.button_icon_spacing)))
    }
}