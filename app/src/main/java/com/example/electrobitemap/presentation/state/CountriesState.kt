package com.example.electrobitemap.presentation.state

data class CountriesState(
    val isLoading: Boolean = false,
    val countries: List<Pair<String, Boolean>> = listOf(Pair("Germany", false)),
    val error: String = "",
)