package com.anna.greeneats.data.cooked_recipes.di

import com.anna.greeneats.data.cooked_recipes.CookedRecipesRepository
import com.anna.greeneats.data.cooked_recipes.FirestoreCookedRecipesRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CookedRecipesModule {
  @Provides
  fun getFirestoreDb(): FirebaseFirestore = Firebase.firestore

  @Provides
  fun bindCookedRecipesRepository(db: FirebaseFirestore): CookedRecipesRepository = FirestoreCookedRecipesRepository(db)
}