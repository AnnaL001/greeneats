package com.anna.greeneats.data.auth

import android.content.Context
import com.anna.greeneats.model.main.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
  val loggedInUser: FirebaseUser?
  val isLoggedIn: Boolean
  val isVerified: Boolean?
  suspend fun updateProfile(name: String?, photo: String?): Resource<Boolean>
  suspend fun signupWithEmail(email: String, password: String): Resource<FirebaseUser>
  suspend fun loginWithEmail(email: String, password: String): Resource<FirebaseUser>
  suspend fun loginWithGoogle(context: Context): Resource<FirebaseUser>
  suspend fun sendVerificationEmail(user: FirebaseUser): Resource<Boolean>
  fun logout()
}