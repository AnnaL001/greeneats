package com.anna.greeneats.data.app_settings.di

import com.anna.greeneats.data.app_settings.AppSettingsRepository
import com.anna.greeneats.data.app_settings.FirebaseAppSettingsRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppSettingsModule {
  @Provides
  fun getFirestoreDb(): FirebaseFirestore = Firebase.firestore

  @Provides
  fun bindAppSettingsRepository(db: FirebaseFirestore): AppSettingsRepository = FirebaseAppSettingsRepository(db)

}