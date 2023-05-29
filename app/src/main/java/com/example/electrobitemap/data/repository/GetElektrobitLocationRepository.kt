package com.example.electrobitemap.data.repository

import com.example.electrobitemap.data.model.Elektrobit

interface GetElektrobitLocationRepository {
    suspend fun getLocationByCountry(country: String) : List<Elektrobit>
    suspend fun saveElektrobitLocation(elektrobit: Elektrobit)
    suspend fun getLocationsByCountry(countries: List<String>): List<Elektrobit>
}