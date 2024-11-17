package com.anna.greeneats.model.app_settings

data class AppSettings(
  val health: List<String> = listOf(),
  val diet: List<String> = listOf(),
  val cuisine: List<String> = listOf()
)