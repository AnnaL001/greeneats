package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable

@Serializable
data class Recipe (

 var uri            : String?                = null,
 var label          : String?                = null,
 var image          : String?                = null,
 var images         : Images?                = Images(),
 var source         : String?                = null,
 var url            : String?                = null,
 var yield          : Double?                 = null,
 var dietLabels     : ArrayList<String>      = arrayListOf(),
 var healthLabels   : ArrayList<String>      = arrayListOf(),
 var cautions       : ArrayList<String>      = arrayListOf(),
 var ingredients    : ArrayList<Ingredients> = arrayListOf(),
 var calories       : Double?                = null,
 var totalWeight    : Double?                = null,
 var totalTime      : Double?                   = null,
 var cuisineType    : ArrayList<String>      = arrayListOf(),
 var mealType       : ArrayList<String>      = arrayListOf(),
 var dishType       : ArrayList<String>      = arrayListOf(),
 var totalNutrients : TotalNutrients?        = TotalNutrients()

)