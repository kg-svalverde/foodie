package com.konrad.intership12026.feature.initialsetup.model

data class InitialSetupState(
    val name: String = "",
    val dietaryPreference: String = "",
    val allergies: List<String> = emptyList()
)