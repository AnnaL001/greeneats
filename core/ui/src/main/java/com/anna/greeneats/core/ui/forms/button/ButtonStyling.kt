package com.anna.greeneats.core.ui.forms.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp

/**
 * The color scheme for the button without an icon
 * @return Button color scheme
 */
@Composable
fun buttonColorScheme(): ButtonColors{
  return ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.secondary,
    contentColor = MaterialTheme.colorScheme.onSecondary,
    disabledContainerColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
    disabledContentColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
  )
}

/**
 * Spacer styling for button with icon
 * @param modifier Modifier object to add styling
 * @param spacing Desired padding/spacing
 */
fun Modifier.spacing(modifier: Modifier, spacing: Dp): Modifier{
  return this.then(modifier.padding(start = spacing, end = spacing))
}

/**
 * Icon styling for button with icon
 * @param modifier Modifier object to add styling
 * @param iconSize Desired icon size
 * @return Modifier object with icon styling
 */
fun Modifier.iconSizing(modifier: Modifier, iconSize: Dp): Modifier{
  return this.then(modifier.size(iconSize))
}

/**
 * Styling for button without icon
 * @param modifier Modifier object to add styling
 * @return Modifier object with button styling
 */
fun Modifier.greenEatsButton(modifier: Modifier, size: Dp): Modifier{
  return this.then(
    modifier
      .height(size)
      .fillMaxWidth())
}

/**
 * Styling for button with icon
 * @param modifier Modifier object to add styling
 * @param onClick Function to be performed when the button is clicked
 * @return Modifier object with button styling
 */
@Composable
fun Modifier.greenEatsButtonWithIcon(modifier: Modifier, size: Dp, onClick: () -> Unit, color: CustomButtonColor? ): Modifier{
  return this.then(
    modifier
      .height(size)
      .fillMaxWidth()
      .background(
        color = color?.bgColor ?: MaterialTheme.colorScheme.secondary,
        shape = CircleShape
      )
      .clickable(role = Role.Button) { onClick() }
  )
}
