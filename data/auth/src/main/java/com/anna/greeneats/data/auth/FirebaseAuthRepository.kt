package com.anna.greeneats.data.auth

import android.content.Context
import android.net.Uri
import com.anna.greeneats.data.auth.google.GoogleSignInContract
import com.anna.greeneats.model.main.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.UserProfileChangeRequest
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class FirebaseAuthRepository @Inject constructor(
  private val auth: FirebaseAuth,
  private val googleSignInContract: GoogleSignInContract
)  : AuthRepository {

  /**
   * Retrieve logged in user details
   * @return Currently logged in user details
   */
  override val loggedInUser: FirebaseUser?
    get() = auth.currentUser

  /**
   * Check if there's a user is logged in
   * @return If there's a user logged in
   */
  override val isLoggedIn: Boolean
    get() = auth.currentUser != null

  /**
   * Check if the user has been verified
   * @return If the user has been verified
   */
  override val isVerified: Boolean?
    get() = auth.currentUser?.isEmailVerified

  /**
   * Update user profile on Firebase
   * @param name Name of the user
   * @return Whether user profile update has been successful
   */
  override suspend fun updateProfile(name: String?, photo: String?): Resource<Boolean> {
    return try {
      loggedInUser?.updateProfile(
        UserProfileChangeRequest.Builder().setDisplayName(name).setPhotoUri(
        Uri.parse(photo)).build())?.await()
      Timber.d("\uD83D\uDE03️SUCCESS: Profile update successful: {Name: $name}")
      Resource.Success(true)
    } catch (e: Exception){
      Timber.d("\uD83D\uDE14️FAILURE: Profile update unsuccessful: {Name: $name, Error: ${e.message}}")
      e.printStackTrace()
      Resource.Failure(e)
    }
  }

  /**
   * Sign up user with email and password
   * @param email User email
   * @param password User password
   * @return Signed up user details
   */
  override suspend fun signupWithEmail(email: String, password: String): Resource<FirebaseUser> {
    return try {
      val signUpResult = auth.createUserWithEmailAndPassword(email, password).await()
      sendVerificationEmail(signUpResult.user!!)
      Timber.d("\uD83D\uDE03️SUCCESS: Email sign up successful {Email: ${signUpResult.user!!.email}}")
      Resource.Success(signUpResult.user!!)
    } catch (e: Exception){
      Timber.d("\uD83D\uDE14️FAILURE :Email sign up unsuccessful {Email: $email, Error: ${e.message}}")
      e.printStackTrace()
      Resource.Failure(e)
    }
  }

  /**
   * Log in user with email and password
   * @param email User email
   * @param password User password
   * @return Logged in user details
   */
  override suspend fun loginWithEmail(email: String, password: String): Resource<FirebaseUser> {
    return try {
      val loginResult = auth.signInWithEmailAndPassword(email, password).await()
      Timber.d("\uD83D\uDE03️SUCCESS: Email login successful {Email: ${loginResult.user?.email}}")
      Resource.Success(loginResult.user!!)
    } catch (e: Exception){
      Timber.d("\uD83D\uDE14️FAILURE: Email login unsuccessful {Email: $email, Error: ${e.message}}")
      e.printStackTrace()
      Resource.Failure(e)
    }
  }

  /** Login with Google Account */
  override suspend fun loginWithGoogle(context: Context): Resource<FirebaseUser> {
    return when(val response = googleSignInContract.getGoogleIdToken(context)){
      is Resource.Success -> handleGoogleLogin(response.result)
      is Resource.Failure -> {
        Timber.d("\uD83D\uDE14️FAILURE: Can't proceed with google login due to error getting Google Token: ${response.exception.message}")
        response.exception.printStackTrace()
        Resource.Failure(response.exception)
      }
    }
  }

  private suspend fun handleGoogleLogin(googleToken: String): Resource<FirebaseUser>{
    return try {
      val firebaseCredential = GoogleAuthProvider.getCredential(googleToken, null)
      val signInResult = auth.signInWithCredential(firebaseCredential).await()
      Timber.d("\uD83D\uDE03️SUCCESS: Google sign in successful {Email: ${signInResult.user?.email}}")
      Resource.Success(signInResult.user!!)
    } catch (e: Exception){
      Timber.d("\uD83D\uDE14️FAILURE: Google sign in unsuccessful {Error: ${e.message}}")
      e.printStackTrace()
      Resource.Failure(e)
    }
  }

  override suspend fun sendVerificationEmail(user: FirebaseUser): Resource<Boolean> {
    return try {
      val sentEmailVerificationResult = user.sendEmailVerification().isSuccessful
      Timber.d("\uD83D\uDE03️SUCCESS: Sending email verification successful {Email: ${user.email}}")
      Resource.Success(sentEmailVerificationResult)
    } catch (e: Exception){
      Timber.d("\uD83D\uDE14️FAILURE: Sending email verification unsuccessful {Email: ${user.email}, Error: ${e.message}}")
      e.printStackTrace()
      Resource.Failure(e)
    }
  }

  /**
   * Logout user
   */
  override fun logout() {
    auth.signOut()
  }
}