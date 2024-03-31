package com.anna.greeneats.core.ui.layout.bottom_sheet

import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import com.anna.greeneats.core.ui.R

/**
 * Bottom sheet drag handle styling
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreenEatsEatsBottomSheetDragHandle(){
  BottomSheetDefaults.DragHandle(
    color = MaterialTheme.colorScheme.primary
  )
}
/**
 * Defaults for the bottom sheet
 */
@Composable
fun bottomSheetDefaults(): GreenEatsBottomSheetDefaults {
  return GreenEatsBottomSheetDefaults(
    containerColor = MaterialTheme.colorScheme.inverseSurface,
    sheetContainerColor = MaterialTheme.colorScheme.surface,
    sheetPeekHeight = dimensionResource(id = R.dimen.default_sheet_peek_height))
}







