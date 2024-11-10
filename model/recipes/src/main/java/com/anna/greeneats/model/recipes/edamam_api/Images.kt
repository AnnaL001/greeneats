package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable


@Serializable
data class Images (

  var THUMBNAIL : THUMBNAIL? = THUMBNAIL(),
  var SMALL     : SMALL?     = SMALL(),
  var REGULAR   : REGULAR?   = REGULAR()

)