package com.anna.greeneats.model.recipes.edamam_api

import kotlinx.serialization.Serializable

@Serializable
data class TotalNutrients (

  var ENERCKCAL   : ENERCKCAL?   = ENERCKCAL(),
  var FAT         : FAT?         = FAT(),
  var FASAT       : FASAT?       = FASAT(),
  var FATRN       : FATRN?       = FATRN(),
  var FAMS        : FAMS?        = FAMS(),
  var FAPU        : FAPU?        = FAPU(),
  var CHOCDF      : CHOCDF?      = CHOCDF(),
  var FIBTG       : FIBTG?       = FIBTG(),
  var SUGAR       : SUGAR?       = SUGAR(),
  var PROCNT      : PROCNT?      = PROCNT(),
  var CHOLE       : CHOLE?       = CHOLE(),
  var NA          : NA?          = NA(),
  var CA          : CA?          = CA(),
  var MG          : MG?          = MG(),
  var K           : K?           = K(),
  var FE          : FE?          = FE(),
  var ZN          : ZN?          = ZN(),
  var P           : P?           = P(),
  var VITARAE     : VITARAE?     = VITARAE(),
  var VITC        : VITC?        = VITC(),
  var THIA        : THIA?        = THIA(),
  var RIBF        : RIBF?        = RIBF(),
  var NIA         : NIA?         = NIA(),
  var VITB6A      : VITB6A?      = VITB6A(),
  var FOLDFE      : FOLDFE?      = FOLDFE(),
  var FOLFD       : FOLFD?       = FOLFD(),
  var FOLAC       : FOLAC?       = FOLAC(),
  var VITB12      : VITB12?      = VITB12(),
  var VITD        : VITD?        = VITD(),
  var TOCPHA      : TOCPHA?      = TOCPHA(),
  var VITK1       : VITK1?       = VITK1(),
  var WATER       : WATER?       = WATER()

)