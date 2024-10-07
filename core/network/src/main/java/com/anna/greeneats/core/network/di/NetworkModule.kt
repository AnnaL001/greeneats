package com.anna.greeneats.core.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  fun provideHttpClient() = HttpClient {
    install(DefaultRequest){
      header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

    install(ContentNegotiation) {
      json(Json {
          encodeDefaults = true
          ignoreUnknownKeys = true
          prettyPrint = true
          isLenient = true
        }
      )
    }

    install(Logging){
      logger = Logger.DEFAULT
      level = LogLevel.BODY
      filter { request ->
        request.url.host.contains("api.edamam.com")
      }
      sanitizeHeader { header -> header == HttpHeaders.Authorization }
    }

    install(Resources)
  }
}
