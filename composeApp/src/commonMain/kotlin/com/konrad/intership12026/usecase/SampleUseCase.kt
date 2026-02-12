package com.konrad.intership12026.usecase

import com.konrad.intership12026.model.SampleAppModel
import com.konrad.network.repository.SampleRepository
import org.koin.core.annotation.Single

@Single
class SampleUseCase(private val repository: SampleRepository) {
    suspend fun fetchSample(): Result<List<SampleAppModel>> {
        return repository.fetchSample().map { result ->
            result.map { model ->
                SampleAppModel(
                    name = model.attributes.name,
                    description = model.attributes.description
                )
            }
        }
    }
}