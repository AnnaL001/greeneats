package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable


@Serializable
data class Ingredients (

 var text         : String? = null,
 var quantity     : Double?    = null,
 var measure      : String? = null,
 var food         : String? = null,
 var weight       : Double?    = null,
 var foodCategory : String? = null,
 var foodId       : String? = null,
 var image        : String? = null

)