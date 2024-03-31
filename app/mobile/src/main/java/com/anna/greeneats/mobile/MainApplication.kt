package com.anna.greeneats.mobile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    registerTimber()
  }

  private fun registerTimber() {
    Timber.plant(Timber.DebugTree())
  }
}