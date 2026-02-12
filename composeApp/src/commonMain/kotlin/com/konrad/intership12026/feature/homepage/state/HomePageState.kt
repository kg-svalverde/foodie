package com.konrad.intership12026.feature.homepage.state

import com.konrad.intership12026.model.SampleAppModel

data class HomePageState(
    val information: List<SampleAppModel> = emptyList()
)