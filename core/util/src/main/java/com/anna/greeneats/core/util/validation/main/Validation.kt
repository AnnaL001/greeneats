package com.anna.greeneats.core.util.validation.main

interface Validation<T>{
  fun validate(input: String): T
}