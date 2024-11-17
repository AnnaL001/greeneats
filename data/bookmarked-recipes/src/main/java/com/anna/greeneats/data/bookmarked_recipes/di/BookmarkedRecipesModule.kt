package com.anna.greeneats.data.bookmarked_recipes.di

import com.anna.greeneats.data.bookmarked_recipes.BookmarkedRecipeRepository
import com.anna.greeneats.data.bookmarked_recipes.FirestoreBookmarkedRecipeRepository
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BookmarkedRecipesModule {
  @Provides
  fun getFirestoreDb(): FirebaseFirestore = Firebase.firestore

  @Provides
  fun bindBookmarkedRepository(db: FirebaseFirestore): BookmarkedRecipeRepository = FirestoreBookmarkedRecipeRepository(db)
}