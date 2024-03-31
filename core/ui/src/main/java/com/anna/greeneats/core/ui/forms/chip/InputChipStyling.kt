package com.anna.greeneats.core.ui.forms.chip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableChipColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.anna.greeneats.core.ui.R

@Composable
fun LeadingIcon() {
  Icon(
      painter = painterResource(id = R.drawable.nutrition),
      modifier = Modifier.size(20.dp),
      contentDescription = "")
}

@Composable
fun chipColors(): SelectableChipColors {
  return InputChipDefaults.inputChipColors(
      containerColor = MaterialTheme.colorScheme.surface,
      labelColor = MaterialTheme.colorScheme.onSecondary,
      leadingIconColor = MaterialTheme.colorScheme.onSecondary,
      trailingIconColor = MaterialTheme.colorScheme.onSecondary,
      selectedContainerColor = MaterialTheme.colorScheme.inversePrimary)
}

@Composable
fun chipBorder(selected: Boolean): BorderStroke {
  return InputChipDefaults.inputChipBorder(
    enabled = true ,
    selected = selected,
    borderColor = MaterialTheme.colorScheme.primary,
    selectedBorderColor = MaterialTheme.colorScheme.primary)
}
