package com.anna.greeneats.core.ui.layout.card

import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.anna.greeneats.core.ui.R

@Composable
fun greenEatsCardColor(): CardColors{
  return CardDefaults.elevatedCardColors(
    containerColor = MaterialTheme.colorScheme.surfaceVariant
  )
}

@Composable
fun greenEatsCardElevation(): CardElevation{
  return CardDefaults.elevatedCardElevation(
    defaultElevation = dimensionResource(id = R.dimen.card_elevation),
    focusedElevation = dimensionResource(id = R.dimen.card_elevation),
    pressedElevation = dimensionResource(id = R.dimen.card_elevation),
    hoveredElevation = dimensionResource(id = R.dimen.card_elevation)
  )
}