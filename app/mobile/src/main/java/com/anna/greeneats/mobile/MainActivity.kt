package com.anna.greeneats.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.anna.greeneats.core.ui.theme.GreenEatsTheme
import com.anna.greeneats.navigation.main.MainNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GreenEatsTheme { Surface(modifier = Modifier.fillMaxSize()) { MainNavigation() } }
    }
  }
}
