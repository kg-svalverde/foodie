package com.konrad.intership12026.feature.marketmap.model

sealed interface MarketMapIntent {

    data object NavigateToProfile: MarketMapIntent

}