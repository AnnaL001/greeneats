package com.anna.greeneats.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anna.greeneats.core.ui.forms.button.GreenEatsButton
import com.anna.greeneats.core.ui.layout.card.GreenEatsCard

@Composable
internal fun HomeScreenInt(
  onNavigateToRecipe: () -> Unit = {},
  onNavigateToCookedRecipes: () -> Unit = {}
) {
  Column(
      modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
        GreenEatsCard(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp, horizontal = 8.dp)) {
              Text(text = "Recipes")

              GreenEatsButton(
                modifier = Modifier.padding(top = 16.dp),
                buttonText = "Go to recipe details",
                onClick = { onNavigateToRecipe() }
              )

              GreenEatsButton(
                modifier = Modifier.padding(top = 16.dp),
                buttonText = "Go to cooked recipes",
                onClick = { onNavigateToCookedRecipes() }
              )
            }
      }
}
