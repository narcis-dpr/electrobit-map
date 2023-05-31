package com.example.electrobitemap.presentation.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.electrobitemap.domain.GetAllCountriesUseCase
import com.example.electrobitemap.domain.GetLocationByCountryUseCase
import com.example.electrobitemap.domain.GetLocationsByCountryUseCase
import com.example.electrobitemap.domain.SaveElektrobitLocationUseCase
import com.example.electrobitemap.presentation.event.FilterEvent
import com.example.electrobitemap.presentation.state.CountriesState
import com.example.electrobitemap.presentation.state.ElektrobitState
import com.example.electrobitemap.presentation.state.MapState
import com.example.electrobitemap.utiles.MapStyle
import com.example.electrobitemap.utiles.ResultWrapper
import com.google.android.gms.maps.model.MapStyleOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ElectrobitLocationViewModel @Inject constructor(
    private val getLocationByCountryUseCase: GetLocationByCountryUseCase,
    private val saveElektrobitLocationUseCase: SaveElektrobitLocationUseCase,
    private val getLocationsByCountryUseCase: GetLocationsByCountryUseCase,
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel() {
    init {
        getAllCountries()
    }

    var state by mutableStateOf(MapState())
    private val _elektrobitLocations = mutableStateOf(ElektrobitState())
    val elektrobitLocations: State<ElektrobitState> = _elektrobitLocations

    private val _elektrobitCountries = mutableStateOf(CountriesState())
    val elektrobitCountries: State<CountriesState> = _elektrobitCountries

    fun getElectrobitLocationByCountryName(country: String) {
        getLocationByCountryUseCase(country).onEach { result ->
            when (result) {
                is ResultWrapper.Error -> {
                    _elektrobitLocations.value =
                        ElektrobitState(error = result.exception.toString() ?: "Unknown Error")
                }

                ResultWrapper.Loading -> {
                    _elektrobitLocations.value = ElektrobitState(isLoading = true)
                }

                is ResultWrapper.Success -> {
                    _elektrobitLocations.value = ElektrobitState(locations = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getAllCountries() {
        getAllCountriesUseCase(Unit).onEach { result ->
            when (result) {
                is ResultWrapper.Error -> {
                    _elektrobitCountries.value =
                        CountriesState(error = result.exception.toString() ?: "Unknown Error")
                }

                ResultWrapper.Loading -> {
                    _elektrobitCountries.value = CountriesState(isLoading = true)
                }

                is ResultWrapper.Success -> {
                    _elektrobitCountries.value =
                        CountriesState(countries = result.data.map { Pair(it, false) })
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onFilterEvent(filterEvent: FilterEvent) {
       when(filterEvent) {
           is FilterEvent.OnFilterClick -> {
               getElectrobitLocationByCountryName(filterEvent.countryFilter.first)
           }
           FilterEvent.ToggleFalloutMap -> {
               state = state.copy(
                   properties = state.properties.copy(
                       mapStyleOptions = if(state.isFalloutMap) {
                           null
                       } else MapStyleOptions(MapStyle.json),
                   ),
                   isFalloutMap = !state.isFalloutMap
               )
           }
       }
    }
}