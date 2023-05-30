package com.example.electrobitemap.data.remote

import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.data.model.ElektrobitResponse
import ir.logicbase.mockfit.Mock
import retrofit2.http.GET


interface ElektrobitApi {
    @Mock("data.json")
    @GET("elektrobit")
    suspend fun getElectroLocations() : List<ElektrobitResponse>
}