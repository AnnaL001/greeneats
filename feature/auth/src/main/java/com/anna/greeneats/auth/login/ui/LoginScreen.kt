package com.anna.greeneats.auth.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.anna.greeneats.auth.login.state.LoginScreenState
import com.anna.greeneats.auth.common.boldGreenStyling
import com.anna.greeneats.auth.common.emailValidationMsg
import com.anna.greeneats.auth.common.passwordValidationMsg
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.forms.button.GreenEatsButton
import com.anna.greeneats.core.ui.forms.email.GreenEatsEmailField
import com.anna.greeneats.core.ui.forms.password.GreenEatsPasswordField
import com.anna.greeneats.core.ui.layout.bottom_sheet.GreenEatsBottomSheet
import com.anna.greeneats.core.ui.normalStyling
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password
import timber.log.Timber

/**
 * Login screen UI
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenUI(
  loginState: LoginScreenState = LoginScreenState(),
  onSignUpNavigation: () -> Unit = {},
  onPasswordVisibilityToggle: () -> Unit = {},
  onLoginValidation: () -> Unit = {},
  onEmailChange: (String) -> Unit = {},
  onPasswordChange: (String) -> Unit = {},
  scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
  onNavigateToHome: () -> Unit = {},
  onLogin: () -> Unit = {}
) {

  GreenEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { LoginForm(loginState, onSignUpNavigation, onEmailChange, onPasswordChange, onLoginValidation, onPasswordVisibilityToggle, onNavigateToHome, onLogin) },
    sheetPeekHeight = dimensionResource(R.dimen.login_sheet_peek_height)
  ) {
    Column {
      Image(
        painter = painterResource(id = R.drawable.healthy_lifestyle),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(0.45F))
    }
  }
}

/**
 * Login form
 */
@Composable
private fun LoginForm(
  loginState: LoginScreenState = LoginScreenState(),
  onSignUpNavigation: () -> Unit = {},
  onEmailChange: (String) -> Unit = {},
  onPasswordChange: (String) -> Unit = {},
  onLoginValidation: () -> Unit = {},
  onPasswordVisibilityToggle: () -> Unit = {},
  onNavigateToHome: () -> Unit = {},
  onLogin: () -> Unit = {}
){
  Column(
    modifier = Modifier.padding(
      top = dimensionResource(R.dimen.small_padding),
      bottom = dimensionResource(R.dimen.medium_padding),
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = stringResource(R.string.login_title),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(R.dimen.medium_padding)),
      style = boldGreenStyling()
    )

    Text(
      text = stringResource(R.string.login_subtitle),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(R.dimen.large_padding)),
      style = normalStyling()
    )

    GreenEatsEmailField(
      inputState = loginState.email,
      onValueChange = onEmailChange,
      placeholder = stringResource(R.string.email_placeholder),
      isError = loginState.emailErrorState.isEmailError,
      errorMessage = emailValidationMsg(loginState.emailErrorState.emailValidation),
      modifier = Modifier.padding(
        start =  dimensionResource(R.dimen.screen_medium_padding),
        end = dimensionResource(R.dimen.screen_medium_padding),
      )
    )

    GreenEatsPasswordField(
      inputState = loginState.password,
      onValueChange = onPasswordChange,
      passwordHidden = loginState.passwordHidden,
      onPasswordVisibilityToggle = onPasswordVisibilityToggle,
      placeholder = stringResource(R.string.password_placeholder),
      isError = loginState.passwordErrorState.isPasswordError,
      errorMessage = passwordValidationMsg(loginState.passwordErrorState.passwordValidation),
      modifier = Modifier.padding(
        top = dimensionResource(R.dimen.small_medium_padding),
        start = dimensionResource(R.dimen.screen_medium_padding),
        end = dimensionResource(R.dimen.screen_medium_padding)
      )
    )

    GreenEatsButton(
      buttonText = stringResource(id = R.string.btn_login),
      onClick = {
        onLoginValidation()
      },
      modifier = Modifier.padding(
        top = dimensionResource(R.dimen.medium_padding),
        start = dimensionResource(R.dimen.small_medium_padding),
        end = dimensionResource(R.dimen.small_medium_padding)
      )
    )

    LaunchedEffect(loginState.emailErrorState.emailValidation == Email.VALID_EMAIL && loginState.passwordErrorState.passwordValidation == Password.VALID_PASSWORD){
      if(loginState.emailErrorState.emailValidation == Email.VALID_EMAIL && loginState.passwordErrorState.passwordValidation == Password.VALID_PASSWORD){
        onLogin()
      }
    }

    LaunchedEffect(loginState.navigateToHome){
      if(loginState.navigateToHome){
        onNavigateToHome()
      }
    }

    Text(
      text = stringResource(R.string.sign_up_redirect_link),
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline,
      modifier = Modifier
        .padding(top = dimensionResource(R.dimen.small_padding))
        .clickable { onSignUpNavigation() },
      style = normalStyling()
    )
  }
}