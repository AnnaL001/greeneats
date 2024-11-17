package com.anna.greeneats.data.cooked_recipes

import com.anna.greeneats.model.main.Resource
import com.anna.greeneats.model.recipes.edamam_api.Recipe
import com.anna.greeneats.model.saved_recipes.RecipeStatus
import com.anna.greeneats.model.saved_recipes.SavedRecipe
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject
import com.google.firebase.firestore.toObjects
import com.google.firebase.firestore.toObject

class FirestoreCookedRecipesRepository @Inject constructor(
  private val _db: FirebaseFirestore
): CookedRecipesRepository {

  override suspend fun addCookedRecipe(userId: String, recipe: Recipe): Resource<Boolean> {
    val edamamId = (recipe.uri as String).split("_")[1]

    return try {
      val cookedRecipeRef = this._db.collection("users/${userId}/cooked-recipes")
      val cookedRecipe = SavedRecipe(id = cookedRecipeRef.document().id, edamamId = edamamId, recipe = recipe, status = RecipeStatus.COOKED.name)

      cookedRecipeRef.document(cookedRecipe.id)
        .set(cookedRecipe)
        .await()
      Timber.d("[SUCCESS] - Adding cooked recipe of id ${cookedRecipe.edamamId} was successful")
      Resource.Success(true)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Adding cooked recipe of id $edamamId was not successful")
      Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchCookedRecipes(userId: String): Resource<List<SavedRecipe>> {
    return try {
      val cookedRecipes = this._db.collection("users/$userId/cooked-recipes")
        .get()
        .await()
        .toObjects<SavedRecipe>()
      Timber.d("[SUCCESS] - Cooked recipes for user with id $userId successfully fetched")
      Resource.Success(result = cookedRecipes)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Error fetching cooked recipes for user with id $userId: ${e.message}")
      Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchCookedRecipe(userId: String, savedRecipeId: String): Resource<SavedRecipe> {
    return try {
      val cookedRecipe = this._db.collection("users/$userId/cooked-recipes").document(savedRecipeId)
        .get()
        .await()
        .toObject<SavedRecipe>()
      Timber.d("[SUCCESS] - Cooked recipe of id $savedRecipeId successfully fetched for user $userId")
      Resource.Success(result = cookedRecipe)
    } catch (e: FirebaseException){
      Timber.e("[FAIL] - Error while fetching cooked recipe $savedRecipeId for user $userId")
      Resource.Failure(exception = e)
    }
  }
}