package com.konrad.network.service

import com.konrad.network.model.SampleApiModel
import com.konrad.network.model.SampleApiModelList
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Single

interface SampleService {
    suspend fun fetchSample(): List<SampleApiModel>
}

@Single
class SampleServiceImpl(
    private val client: HttpClient
) : SampleService {
    override suspend fun fetchSample(): List<SampleApiModel> {
        val result: SampleApiModelList = client.get("breeds").body()
        return result.data
    }
}