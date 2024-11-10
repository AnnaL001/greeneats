package com.anna.greeneats.network.recipes.utils

import com.anna.greeneats.model.main.Resource
import timber.log.Timber

suspend fun <T: Any> safeApiCall(
  apiRequest: suspend () -> T
): Resource<T> = try {
  Resource.Success(apiRequest.invoke())
} catch (e: Exception) {
  Timber.e(e.cause)
  handleErrors(e)
}