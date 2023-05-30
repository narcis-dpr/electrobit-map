package com.example.electrobitemap.presentation.event

import com.example.electrobitemap.presentation.state.CountryFilter

sealed class FilterEvent {
    data class OnFilterClick(val countryFilter: CountryFilter) : FilterEvent()
}