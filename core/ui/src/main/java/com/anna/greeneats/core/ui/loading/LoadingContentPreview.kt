package com.anna.greeneats.core.ui.loading

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.theme.GreenEatsTheme

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoadingContentPreview() {
  GreenEatsTheme {
    LoadingContent(isSuccess = true, text = stringResource(id = R.string.sign_up_loading))
  }
}
