package com.konrad.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SampleApiModelList(
    val data: List<SampleApiModel>
)

@Serializable
data class SampleApiModel(
    val attributes: SampleApiModelAttributes
)

@Serializable
data class SampleApiModelAttributes(
    val name: String,
    val description: String,
)