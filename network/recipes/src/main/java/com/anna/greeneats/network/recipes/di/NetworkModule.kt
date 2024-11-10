package com.anna.greeneats.network.recipes.di

import com.anna.greeneats.network.recipes.EdamamApi
import com.anna.greeneats.network.recipes.utils.EdamamApiRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  fun provideHttpClient() = HttpClient {
    defaultRequest{
      header(HttpHeaders.ContentType, ContentType.Application.Json)
      header(HttpHeaders.Accept, ContentType.Application.Json)
      header("Accept-Language", "en")

      url {
        protocol = URLProtocol.HTTPS
        host = EdamamApiRequest.Endpoint.HOST
        path(EdamamApiRequest.Endpoint.RECIPES_SEARCH_URL)
        parameters.append(EdamamApiRequest.QueryParams.AppId.KEY, EdamamApiRequest.QueryParams.AppId.VALUE)
        parameters.append(EdamamApiRequest.QueryParams.ApiKey.KEY, EdamamApiRequest.QueryParams.ApiKey.VALUE)
        parameters.append(EdamamApiRequest.QueryParams.RecipeType.TYPE_KEY, EdamamApiRequest.QueryParams.RecipeType.TYPE_VALUE)
      }
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

  @Provides
  fun provideEdamamApi(client: HttpClient) = EdamamApi(client = client)
}
