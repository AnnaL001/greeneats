package com.anna.greeneats.core.ui.layout.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.anna.greeneats.core.ui.R

@Composable
fun GreenEatsCard(
  modifier: Modifier = Modifier,
  elevation: CardElevation = greenEatsCardElevation(),
  content: @Composable () -> Unit
){
  ElevatedCard(
    modifier = modifier,
    colors = greenEatsCardColor(),
    elevation = elevation,
  ){
    Column(
      modifier = modifier.padding (dimensionResource(id = R.dimen.medium_padding)),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally) {
      content()
    }
  }
}
