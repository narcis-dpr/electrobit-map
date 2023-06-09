package com.example.electrobitemap.domain

import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.data.repository.GetElektrobitLocationRepository
import com.example.electrobitemap.di.IoDispatcher
import com.example.electrobitemap.utiles.ResultWrapper
import com.example.electrobitemap.utiles.UseCaseHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetLocationsByCountryUseCase @Inject constructor(
    private val getElektrobitLocationRepository: GetElektrobitLocationRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCaseHelper<List<String>, List<Elektrobit>?>(ioDispatcher) {
    override fun execute(parameter: List<String>): Flow<ResultWrapper<List<Elektrobit>?>> = flow {
        try {
            emit(ResultWrapper.Loading)
            val locations = getElektrobitLocationRepository.getLocationsByCountry(parameter)
            emit(ResultWrapper.Success(locations))
        } catch (e: HttpException) {
            emit(ResultWrapper.Error(e))
        }

    }
}