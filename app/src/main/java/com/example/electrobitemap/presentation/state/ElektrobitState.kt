package com.example.electrobitemap.presentation.state

import com.example.electrobitemap.data.model.Elektrobit

data class ElektrobitState (
    val isLoading: Boolean = false,
    val locations: List<Elektrobit> = emptyList(),
    val error: String = ""
        )