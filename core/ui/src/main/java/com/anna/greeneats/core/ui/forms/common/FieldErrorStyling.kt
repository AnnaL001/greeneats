package com.anna.greeneats.core.ui.forms.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.anna.greeneats.core.ui.R


/**
 * Error icon to be displayed when form validation fails
 */
@Composable
fun ErrorTrailingIcon(){
  Icon(
    painter = painterResource(id = R.drawable.error_icon),
    contentDescription = stringResource(id = R.string.error_icon)
  )
}

/**
 * Error text to be displayed when form validation fails
 * @param modifier Modifier instance to add styling
 * @param errorMessage Error message to be displayed
 */
@Composable
fun GreenEatsFieldError(modifier: Modifier, errorMessage: String){
  Text(
    text = errorMessage,
    color = MaterialTheme.colorScheme.error,
    style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
    modifier = modifier.fillMaxWidth()
  )
}