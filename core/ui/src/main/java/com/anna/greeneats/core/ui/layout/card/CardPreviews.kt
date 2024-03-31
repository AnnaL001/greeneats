package com.anna.greeneats.core.ui.layout.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.anna.greeneats.core.ui.theme.GreenEatsTheme

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CardPreview() {
  GreenEatsTheme {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
          GreenEatsCard { Text(text = "Hey!!!") }
        }
  }
}
