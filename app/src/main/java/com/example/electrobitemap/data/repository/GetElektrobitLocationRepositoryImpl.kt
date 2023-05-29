package com.example.electrobitemap.data.repository

import com.example.electrobitemap.data.local.GetDataDao
import com.example.electrobitemap.data.mapper.mamToEntity
import com.example.electrobitemap.data.mapper.mapToElektrobit
import com.example.electrobitemap.data.mapper.mapToElektrobitResponse
import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.data.remote.ElektrobitApi
import javax.inject.Inject

class GetElektrobitLocationRepositoryImpl @Inject constructor(
    private val elektrobitApi: ElektrobitApi,
    private val getDataDao: GetDataDao
) : GetElektrobitLocationRepository {
    override suspend fun getLocationByCountry(country: String): List<Elektrobit> {
        return if (!getDataDao.getElectrobitLocationByCountry(country).isEmpty()) {
            return getDataDao.getElectrobitLocationByCountry(country)
                .map { it -> it.mapToElektrobit() }
        } else {
            elektrobitApi.getElectroLocations().map { it -> it.mapToElektrobit().mamToEntity() }
                .forEach {
                    getDataDao.insertElectrobitLocation(it)
                }

            return getDataDao.getElectrobitLocationByCountry(country)
                .map { it -> it.mapToElektrobit() }
        }
    }

    override suspend fun saveElektrobitLocation(elektrobit: Elektrobit) {
        getDataDao.insertElectrobitLocation(elektrobit.mamToEntity())
    }

    override suspend fun getLocationsByCountry(countries: List<String>): List<Elektrobit>? {
        val result = mutableListOf<List<Elektrobit>>()
        countries.forEach { country ->
            result.add(
                getDataDao.getElectrobitLocationByCountry(country).map { it.mapToElektrobit() })
        }
        return result.flatten()
    }
}