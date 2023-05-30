package com.example.electrobitemap.presentation.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import com.example.electrobitemap.data.model.Elektrobit

data class CountryFilter(
    val isLoading: Boolean = false,
    val country: List<Pair<String, Boolean>> = listOf(Pair("Germany", false)),
    val error: String = ""
)