package com.konrad.intership12026.feature.initialsetup.model

sealed interface InitialSetupIntent {
    data class UpdateName(val name: String) : InitialSetupIntent
    data class UpdateDietaryPreference(val preference: String) : InitialSetupIntent
    data class AddAllergy(val allergy: String) : InitialSetupIntent
    data class RemoveAllergy(val allergy: String) : InitialSetupIntent
    
    data object NavigateToMealPlanner: InitialSetupIntent
    data object NavigateToMarketMap: InitialSetupIntent
    data object NavigateToProfile: InitialSetupIntent
}
