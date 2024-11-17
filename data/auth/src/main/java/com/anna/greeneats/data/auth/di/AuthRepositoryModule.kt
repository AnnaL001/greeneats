package com.anna.greeneats.data.auth.di

import com.anna.greeneats.data.auth.AuthRepository
import com.anna.greeneats.data.auth.FirebaseAuthRepository
import com.anna.greeneats.data.auth.google.GoogleSignInContract
import com.anna.greeneats.data.auth.user.FirestoreUserRepository
import com.anna.greeneats.data.auth.user.UserRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {
  @Provides
  fun getFirebaseAuth(): FirebaseAuth = Firebase.auth

  @Provides
  fun getFirebaseFirestore(): FirebaseFirestore = Firebase.firestore

  @Provides
  fun getGoogleSignInContract(): GoogleSignInContract = GoogleSignInContract()

  @Provides
  fun bindAuthRepository(
    auth: FirebaseAuth,
    googleSignInContract: GoogleSignInContract): AuthRepository = FirebaseAuthRepository(auth, googleSignInContract)

  @Provides
  fun bindUserRepository(db: FirebaseFirestore): UserRepository = FirestoreUserRepository(db)
}