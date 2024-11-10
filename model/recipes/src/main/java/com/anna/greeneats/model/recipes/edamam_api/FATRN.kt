package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable


@Serializable
data class FATRN (

   var label    : String? = null,
   var quantity : Double?    = null,
   var unit     : String? = null

)