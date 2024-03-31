package com.anna.greeneats.core.ui.layout.bottom_sheet

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreenEatsBottomSheet(
  scaffoldState: BottomSheetScaffoldState,
  sheetContent: @Composable (ColumnScope.() -> Unit),
  sheetPeekHeight: Dp ?= null,
  content: @Composable (() -> Unit)
){
  BottomSheetScaffold(
    scaffoldState = scaffoldState,
    sheetPeekHeight = sheetPeekHeight ?: bottomSheetDefaults().sheetPeekHeight,
    sheetContent = sheetContent,
    sheetContainerColor = bottomSheetDefaults().sheetContainerColor,
    containerColor = bottomSheetDefaults().containerColor,
    sheetDragHandle = { GreenEatsEatsBottomSheetDragHandle() }) {
       content()
   }
}