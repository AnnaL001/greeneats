package com.anna.greeneats.data.auth.di

import com.anna.greeneats.data.auth.AuthRepository
import com.anna.greeneats.data.auth.FirebaseAuthRepository
import com.anna.greeneats.data.auth.google.GoogleSignInContract
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {
  @Provides
  fun getFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

  @Provides
  fun getGoogleSignInContract(): GoogleSignInContract = GoogleSignInContract()

  @Provides
  fun bindAuthRepository(
    authRepositoryImpl: FirebaseAuthRepository): AuthRepository = authRepositoryImpl
}