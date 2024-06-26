package com.anna.greeneats.auth.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun boldGreenStyling(): TextStyle {
  return MaterialTheme.typography.headlineSmall.copy(
    color = MaterialTheme.colorScheme.primary
  )
}

@Composable
fun boldGreenTitleStyling(): TextStyle{
  return MaterialTheme.typography.headlineLarge.copy(
    color = MaterialTheme.colorScheme.primary,
  )
}

@Composable
fun subtitleStyling(): TextStyle{
  return MaterialTheme.typography.titleLarge.copy(
    fontWeight = FontWeight.Light
  )
}