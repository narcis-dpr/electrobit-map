package com.example.electrobitemap.presentation.state

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf

@Stable
data class CountryFilter(
    val title: String,
    val selected: Boolean = false
)