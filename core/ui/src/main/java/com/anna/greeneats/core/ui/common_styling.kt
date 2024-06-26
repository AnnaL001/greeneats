package com.anna.greeneats.core.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
fun normalStyling(): TextStyle {
  return MaterialTheme.typography.titleMedium.copy(
    color = MaterialTheme.colorScheme.onSecondary
  )
}