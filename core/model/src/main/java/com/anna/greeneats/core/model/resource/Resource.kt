package com.anna.greeneats.core.model.resource

sealed interface AsyncResource{}

sealed class Resource<out R>: AsyncResource {
  data class Success<out R>(val result: R) : Resource<R>()
  data class Failure(val exception: Exception) : Resource<Nothing>()
}