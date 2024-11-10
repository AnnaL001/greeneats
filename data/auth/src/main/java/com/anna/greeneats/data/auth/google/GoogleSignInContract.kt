package com.anna.greeneats.data.auth.google

import android.content.Context
import android.service.credentials.BeginGetCredentialOption
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.GetCredentialResponse
import androidx.credentials.exceptions.GetCredentialException
import com.anna.greeneats.data.auth.BuildConfig
import com.anna.greeneats.model.main.Resource
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import timber.log.Timber

class GoogleSignInContract{
  private val GOOGLE_CLIENT_ID = BuildConfig.GOOGLE_WEB_CLIENT_ID

  private val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
    .setFilterByAuthorizedAccounts(false)
    .setServerClientId(GOOGLE_CLIENT_ID)
  .build()

  private val request: GetCredentialRequest = GetCredentialRequest.Builder()
    .addCredentialOption(googleIdOption)
    .build()


  suspend fun getGoogleIdToken(context: Context): Resource<String> {
    try {
      val credentialManager: CredentialManager = CredentialManager.create(context)

      val credentialRequest: GetCredentialRequest =
        GetCredentialRequest.Builder().addCredentialOption(googleIdOption).build()

      val result = credentialManager.getCredential(
        request = credentialRequest,
        context = context,
      )
      return handleCredential(result)
    }catch (e: GetCredentialException){
      Timber.e("Error occurred during credential request: $e")
      return Resource.Failure(e)
    }
  }

  private fun handleCredential(result: GetCredentialResponse): Resource<String>{
    when(val credential = result.credential){
      is CustomCredential -> {
        if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
          try {
            // Use googleIdTokenCredential and extract the ID to validate and
            // authenticate on your server(Firebase).
            val googleIdTokenCredential = GoogleIdTokenCredential
              .createFrom(credential.data)
            return Resource.Success(googleIdTokenCredential.idToken)
          } catch (e: GoogleIdTokenParsingException) {
            Timber.e("Received an invalid google id token response", e)
            return Resource.Failure(e)
          }
        } else {
          // Catch any unrecognized custom credential type here.
          Timber.e("Unexpected type of credential")
          return Resource.Failure(Exception("Unexpected type of credential"))
        }
      }
    }

    return Resource.Failure(Exception("No attempt to sign in with Google"))
  }
}