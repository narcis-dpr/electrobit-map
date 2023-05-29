package com.example.electrobitemap.domain

import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.data.repository.GetElektrobitLocationRepository
import com.example.electrobitemap.di.IoDispatcher
import com.example.electrobitemap.utiles.ResultWrapper
import com.example.electrobitemap.utiles.UseCaseHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLocationByCountryUseCase @Inject constructor(
    private val getElektrobitLocationRepository: GetElektrobitLocationRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
): UseCaseHelper<String, List<Elektrobit>>(ioDispatcher) {
    override fun execute(parameter: String): Flow<ResultWrapper<List<Elektrobit>>> = flow {
        getElektrobitLocationRepository.getLocationByCountry(parameter)
    }
}