package com.anna.greeneats.data.app_settings

import com.anna.greeneats.model.app_settings.AppSettings
import com.anna.greeneats.model.main.Resource

interface AppSettingsRepository {
  suspend fun writeAppSettings(userId: String, appSettings: AppSettings): Resource<Boolean>
  suspend fun fetchAppSettings(userId: String): Resource<AppSettings?>
}