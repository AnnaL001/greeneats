package com.anna.greeneats.data.app_settings

import com.anna.greeneats.model.app_settings.AppSettings
import com.anna.greeneats.model.main.Resource
import com.google.firebase.FirebaseException
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class FirebaseAppSettingsRepository @Inject constructor(
  private val _db: FirebaseFirestore
): AppSettingsRepository {

  override suspend fun  writeAppSettings(userId: String, appSettings: AppSettings): Resource<Boolean> {
    return try {
      val addResult = this._db.collection("users/$userId/app-settings").document("app-settings")
                      .set(appSettings)
                      .await()
      Timber.d("[SUCCESS]-App settings successfully added")
      Resource.Success(true)
    }catch (e: FirebaseException){
      Timber.e("[FAIL]-Error while adding app settings: ${e.message}")
      Resource.Failure(exception = e)
    }
  }

  override suspend fun fetchAppSettings(userId: String): Resource<AppSettings?> {
    return try {
      val fetchResult = this._db.collection("users/$userId/app-settings").document("app-settings")
        .get()
        .await()
        .toObject<AppSettings>()
      Timber.d("[SUCCESS]-App settings successfully fetched")
      Resource.Success(fetchResult)
    }catch (e: FirebaseException){
      Timber.e("[FAIL]-Error while fetching app settings: ${e.message}")
      Resource.Failure(exception = e)
    }
  }
}