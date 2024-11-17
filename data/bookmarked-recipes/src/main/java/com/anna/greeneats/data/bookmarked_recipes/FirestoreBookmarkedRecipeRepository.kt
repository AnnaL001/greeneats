package com.anna.greeneats.data.bookmarked_recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.Recipe
import com.anna.greeneats.model.saved_recipes.RecipeStatus
import com.anna.greeneats.model.saved_recipes.SavedRecipe
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class FirestoreBookmarkedRecipeRepository @Inject constructor(
  private val _db: FirebaseFirestore
): BookmarkedRecipeRepository {
  override suspend fun writeBookmarkedRecipes(userId: String, recipe: Recipe): Resource<Boolean> {
    val savedRecipeId = (recipe.uri as String).split("_")[1]

    return try {
      val bookmarkedRecipeRef = this._db.collection("users/$userId/bookmarked-recipes")
      val bookmarkedRecipe = SavedRecipe(id = bookmarkedRecipeRef.document().id, edamamId = savedRecipeId, recipe = recipe, status = RecipeStatus.BOOKMARKED.name)

      bookmarkedRecipeRef.document(bookmarkedRecipe.id)
        .set(bookmarkedRecipe)
        .await()
      Timber.d("[SUCCESS] - Adding of bookmarked recipe ${bookmarkedRecipe.edamamId} for user $userId was successful")
      Resource.Success(true)
    } catch (e: FirebaseException){
        Timber.e("[FAIL] - Error adding bookmarked recipe $savedRecipeId for user $userId : ${e.message}")
        Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchBookmarkedRecipes(userId: String): Resource<List<SavedRecipe>> {
    return try {
      val bookmarkedRecipes = this._db.collection("users/$userId/bookmarked-recipes")
        .get()
        .await()
        .toObjects<SavedRecipe>()
      Timber.d("[SUCCESS] - Fetching bookmarked recipes for user $userId was successful")
      Resource.Success(bookmarkedRecipes)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Error fetching bookmarked recipes for user $userId: ${e.message}")
      Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchBookmarkedRecipe(
    userId: String,
    savedRecipeId: String
  ): Resource<SavedRecipe> {
    return try {
      val bookmarkedRecipe = this._db.collection("users/$userId/bookmarked-recipes").document(savedRecipeId)
        .get()
        .await()
        .toObject<SavedRecipe>()
      Timber.e("[SUCCESS] - Fetching bookmarked recipe $savedRecipeId for user $userId was successful")
      Resource.Success(bookmarkedRecipe)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Error fetching bookmarked recipe $savedRecipeId for user $userId : ${e.message}")
      Resource.Failure(exception = e)
    }
  }
}