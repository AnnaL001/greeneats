package com.anna.greeneats.auth.signup.ui

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
import com.anna.greeneats.auth.common.boldGreenStyling
import com.anna.greeneats.auth.common.confirmPasswordValidationMsg
import com.anna.greeneats.auth.common.emailValidationMsg
import com.anna.greeneats.auth.common.passwordValidationMsg
import com.anna.greeneats.auth.login.state.LoginScreenState
import com.anna.greeneats.auth.signup.state.SignupScreenState
import com.anna.greeneats.core.ui.layout.bottom_sheet.GreenEatsBottomSheet
import com.anna.greeneats.core.ui.R
import com.anna.greeneats.core.ui.forms.button.GreenEatsButton
import com.anna.greeneats.core.ui.forms.email.GreenEatsEmailField
import com.anna.greeneats.core.ui.forms.password.GreenEatsPasswordField
import com.anna.greeneats.core.ui.normalStyling
import com.anna.greeneats.core.util.validation.error.ConfirmPassword
import com.anna.greeneats.core.util.validation.error.Email
import com.anna.greeneats.core.util.validation.error.Password

/**
 * The whole sign up screen UI
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreenUI(
  signupScreenState: SignupScreenState = SignupScreenState(),
  onLoginNavigation: () -> Unit = {},
  onPasswordVisibilityToggle: () -> Unit = {},
  onConfirmPasswordVisibilityToggle: () -> Unit = {},
  onSignupValidation: () -> Unit = {},
  onEmailChange: (String) -> Unit = {},
  onPasswordChange: (String) -> Unit = {},
  onConfirmPasswordChange: (String) -> Unit = {},
  scaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState(),
  onSignup: () -> Unit = {}
) {

  GreenEatsBottomSheet(
    scaffoldState = scaffoldState,
    sheetContent = { SignupForm(signupScreenState, onLoginNavigation, onEmailChange, onPasswordChange, onConfirmPasswordChange, onSignupValidation, onPasswordVisibilityToggle, onConfirmPasswordVisibilityToggle, onSignup) })
  {
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

@Composable
private fun SignupForm(
  signUpState: SignupScreenState = SignupScreenState(),
  onLoginNavigation: () -> Unit = {},
  onEmailChange: (String) -> Unit = {},
  onPasswordChange: (String) -> Unit = {},
  onConfirmPasswordChange: (String) -> Unit = {},
  onSignupValidation: () -> Unit = {},
  onPasswordVisibilityToggle: () -> Unit = {},
  onConfirmPasswordVisibilityToggle: () -> Unit = {},
  onSignup: () -> Unit = {}
){
  Column(
    modifier = Modifier.padding(
      top = dimensionResource(R.dimen.small_padding),
      bottom =  dimensionResource(R.dimen.medium_padding),
    ),
    horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
      text = stringResource(R.string.signup_title),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(R.dimen.medium_padding)),
      style = boldGreenStyling()
    )

    Text(
      text = stringResource(R.string.signup_subtitle),
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(bottom = dimensionResource(R.dimen.large_padding)),
      style = normalStyling()
    )

    GreenEatsEmailField(
      inputState = signUpState.email,
      onValueChange = onEmailChange,
      placeholder = stringResource(R.string.email_placeholder),
      isError = signUpState.emailErrorState.isEmailError,
      errorMessage = emailValidationMsg(signUpState.emailErrorState.emailValidation),
      modifier = Modifier.padding(
        start =  dimensionResource(R.dimen.screen_medium_padding),
        end = dimensionResource(R.dimen.screen_medium_padding),
      )
    )

    GreenEatsPasswordField(
      inputState = signUpState.password,
      onValueChange = onPasswordChange,
      passwordHidden = signUpState.passwordHidden,
      onPasswordVisibilityToggle = onPasswordVisibilityToggle,
      placeholder = stringResource(R.string.password_placeholder),
      isError = signUpState.passwordErrorState.isPasswordError,
      errorMessage = passwordValidationMsg(signUpState.passwordErrorState.passwordValidation),
      modifier = Modifier.padding(
        top = dimensionResource(R.dimen.small_medium_padding),
        start = dimensionResource(R.dimen.screen_medium_padding),
        end = dimensionResource(R.dimen.screen_medium_padding)
      )
    )

    GreenEatsPasswordField(
      inputState = signUpState.confirmPassword,
      onValueChange = onConfirmPasswordChange,
      passwordHidden = signUpState.confirmPasswordHidden,
      onPasswordVisibilityToggle = onConfirmPasswordVisibilityToggle,
      placeholder = stringResource(R.string.confirm_password_placeholder),
      isError = signUpState.confirmPasswordErrorState.isPasswordError,
      errorMessage = confirmPasswordValidationMsg(signUpState.confirmPasswordErrorState.confirmPasswordValidation),
      modifier = Modifier.padding(
        top = dimensionResource(R.dimen.small_medium_padding),
        start = dimensionResource(R.dimen.screen_medium_padding),
        end = dimensionResource(R.dimen.screen_medium_padding)
      )
    )

    LaunchedEffect(
      signUpState.emailErrorState.emailValidation == Email.VALID_EMAIL &&
        signUpState.passwordErrorState.passwordValidation == Password.VALID_PASSWORD &&
        signUpState.confirmPasswordErrorState.confirmPasswordValidation == ConfirmPassword.VALID_CONFIRM_PASSWORD){
      if(signUpState.emailErrorState.emailValidation == Email.VALID_EMAIL && signUpState.passwordErrorState.passwordValidation == Password.VALID_PASSWORD && signUpState.confirmPasswordErrorState.confirmPasswordValidation == ConfirmPassword.VALID_CONFIRM_PASSWORD){
        onSignup()
      }
    }

    LaunchedEffect(signUpState.navigateToLogin){
      if(signUpState.navigateToLogin){
        onLoginNavigation()
      }
    }

    GreenEatsButton(
      buttonText = stringResource(id = R.string.btn_signup),
      onClick = {
        onSignupValidation()
      },
      modifier = Modifier.padding(
        top = dimensionResource(R.dimen.medium_padding),
        start = dimensionResource(R.dimen.small_medium_padding),
        end = dimensionResource(R.dimen.small_medium_padding)
      )
    )

    Text(
      text = stringResource(R.string.login_redirect_link),
      textAlign = TextAlign.Center,
      textDecoration = TextDecoration.Underline,
      modifier = Modifier
        .padding(top = dimensionResource(R.dimen.small_padding))
        .clickable { onLoginNavigation() },
      style = normalStyling()
    )
  }

}