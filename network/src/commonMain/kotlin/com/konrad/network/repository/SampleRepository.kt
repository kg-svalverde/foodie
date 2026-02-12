package com.konrad.network.repository

import com.konrad.network.model.SampleApiModel
import com.konrad.network.service.SampleService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Single

interface SampleRepository {
    suspend fun fetchSample(): Result<List<SampleApiModel>>
}

@Single
class SampleRepositoryImpl(
    private val service: SampleService,
    private val dispatcher: CoroutineDispatcher
) : SampleRepository {
    override suspend fun fetchSample(): Result<List<SampleApiModel>> = runCatching {
        withContext(dispatcher) {
            service.fetchSample()
        }
    }
}