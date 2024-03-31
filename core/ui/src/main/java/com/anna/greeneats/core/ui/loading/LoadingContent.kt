package com.anna.greeneats.core.ui.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.layout.card.GreenEatsCard

@Composable
fun LoadingContent(
  text: String,
  isSuccess: Boolean,
  modifier: Modifier = Modifier){
  Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
      GreenEatsCard {
        Image(
          painter = painterResource(id = R.drawable.loading_img),
          contentDescription = "",
          modifier = Modifier.size(dimensionResource(id = R.dimen.loading_img_size)))


        LinearProgressIndicator(
            modifier = modifier
          .fillMaxWidth(fraction = 0.40F)
          .padding(top = dimensionResource(R.dimen.medium_padding)),
          color = MaterialTheme.colorScheme.secondary
        )

        Text(
          text = text,
          color = if (isSuccess) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
          modifier = Modifier.padding(top = dimensionResource(R.dimen.medium_padding)))
      }
  }
  
}