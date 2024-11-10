package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable


@Serializable
data class THUMBNAIL (

  var url    : String? = null,
  var width  : Int?    = null,
  var height : Int?    = null

)