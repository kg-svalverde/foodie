package com.konrad.network.di.module

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.konrad.network")
class NetworkModule {
    @Single
    fun providesHttpClient(): HttpClient {
        return HttpClient {
            defaultRequest {
                // TODO: Replace with correct URL
                url("https://dogapi.dog/api/v2/")
            }
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    @Single
    fun providesCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO
}