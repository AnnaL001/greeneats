package com.anna.greeneats.data.recipes.di

import com.anna.greeneats.data.recipes.RecipeRepository
import com.anna.greeneats.data.recipes.RecipeRepositoryImpl
import com.anna.greeneats.network.recipes.EdamamApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RecipesModule {
  @Provides
  fun provideRecipeRepo(api: EdamamApi): RecipeRepository = RecipeRepositoryImpl(api)
}