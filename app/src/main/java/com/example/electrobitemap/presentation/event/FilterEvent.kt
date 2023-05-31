package com.example.electrobitemap.presentation.event

import com.example.electrobitemap.presentation.state.CountriesState

sealed class FilterEvent {
    data class OnFilterClick(val countryFilter: Pair<String, Boolean>) : FilterEvent()
    object ToggleFalloutMap: FilterEvent()
}