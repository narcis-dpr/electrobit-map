package com.example.electrobitemap.data.repository

import com.example.electrobitemap.data.model.Elektrobit

class GetElektrobitLocationRepositoryImpl(): GetElektrobitLocationRepository {
    override suspend fun getLocationByCountry(country: String): List<Elektrobit> {
        TODO("Not yet implemented")
    }

    override suspend fun saveElektrobitLocation(elektrobit: Elektrobit) {
        TODO("Not yet implemented")
    }

    override suspend fun getLocationsByCountry(countries: List<String>): List<Elektrobit> {
        TODO("Not yet implemented")
    }
}