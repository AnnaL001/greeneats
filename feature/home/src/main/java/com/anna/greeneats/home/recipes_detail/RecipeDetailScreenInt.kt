package com.anna.greeneats.home.recipes_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anna.greeneats.core.ui.forms.button.GreenEatsButton
import com.anna.greeneats.core.ui.layout.card.GreenEatsCard

@Composable
internal fun RecipeDetailsScreenInt(
  onNavigateToHome: () -> Unit = {}
) {
  Column(
      modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
        GreenEatsCard {
          Text(text = "Recipe details")

          GreenEatsButton(
            modifier = Modifier.padding(top = 16.dp),
            buttonText = "Go back to home",
            onClick = { onNavigateToHome() }
          )
        }
      }
}
