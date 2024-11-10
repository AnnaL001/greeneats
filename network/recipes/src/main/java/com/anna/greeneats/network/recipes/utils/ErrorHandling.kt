package com.anna.greeneats.network.recipes.utils

import com.anna.greeneats.model.main.Resource
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import timber.log.Timber

fun handleErrors(e: Exception): Resource.Failure {
  return when(e){
    // For 5XX responses
    is ServerResponseException -> {
      Timber.e("Server error: ${e.message}")
      Resource.Failure(e)
    }

    is NoTransformationFoundException -> {
      Timber.e("Transformation error: ${e.message}")
      Resource.Failure(e)
    }

    is ConnectTimeoutException -> {
      Timber.e("Network error: ${e.message}")
      Resource.Failure(e)
    }

    // For 4XX responses
    is ClientRequestException -> {
      Timber.e("Client error: ${e.message}")
      Resource.Failure(e)
    }

    else -> {
      Timber.e("Error: ${e.message}")
      Resource.Failure(e)
    }
  }
}
