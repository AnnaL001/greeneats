package com.anna.greeneats.core.ui.layout.divider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.anna.greeneats.core.ui.R

@Composable
fun GreenEatsDivider(
  modifier: Modifier = Modifier,
  dividerColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
  textColor: Color = MaterialTheme.colorScheme.inverseOnSurface,
  text: String = "",
){
  Row(
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    HorizontalDivider(
      thickness = dimensionResource(id = R.dimen.login_divider_thickness),
      color = dividerColor,
      modifier = modifier
        .weight(0.425F)
        .padding(bottom = dimensionResource(id = R.dimen.small_padding))
    )

    Text(
      text = text,
      style = MaterialTheme.typography.bodyMedium,
      color = textColor,
      modifier = modifier.weight(0.15F)
      )

    HorizontalDivider(
      thickness = dimensionResource(id = R.dimen.login_divider_thickness),
      color = dividerColor,
      modifier = modifier
        .weight(0.425F)
        .padding(
          bottom = dimensionResource(id = R.dimen.small_padding), top = dimensionResource(
            id = R.dimen.small_padding
          )
        )
    )
  }
}