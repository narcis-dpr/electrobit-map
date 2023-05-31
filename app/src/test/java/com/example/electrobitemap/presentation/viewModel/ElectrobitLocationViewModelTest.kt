package com.example.electrobitemap.presentation.viewModel

import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.domain.GetAllCountriesUseCase
import com.example.electrobitemap.domain.GetLocationByCountryUseCase
import com.example.electrobitemap.domain.GetLocationsByCountryUseCase
import com.example.electrobitemap.domain.SaveElektrobitLocationUseCase
import com.example.electrobitemap.presentation.state.CountriesState
import com.example.electrobitemap.presentation.state.ElektrobitState
import com.example.electrobitemap.utiles.ResultWrapper
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ElectrobitLocationViewModelTest {
    @Mock
    private lateinit var getLocationByCountryUseCase: GetLocationByCountryUseCase

    @Mock
    private lateinit var saveElektrobitLocationUseCase: SaveElektrobitLocationUseCase

    @Mock
    private lateinit var getLocationsByCountryUseCase: GetLocationsByCountryUseCase

    @Mock
    private lateinit var getAllCountriesUseCase: GetAllCountriesUseCase

    private lateinit var viewModel: ElectrobitLocationViewModel

    @Before
    fun setup() {
        viewModel = ElectrobitLocationViewModel(
            getLocationByCountryUseCase,
            saveElektrobitLocationUseCase,
            getLocationsByCountryUseCase,
            getAllCountriesUseCase
        )
    }

    @Test
    fun `test getAllCountries success`() = runBlocking {
        val countries = listOf("Germany", "France", "Spain")
        val successResult = ResultWrapper.Success(countries)
        `when`(getAllCountriesUseCase(Unit)).thenReturn(flowOf(successResult))

        viewModel.getAllCountries()

        val expectedState = CountriesState(countries = countries.map { Pair(it, false) })
        assertEquals(expectedState, viewModel.elektrobitCountries.value)
    }

    @Test
    fun `test getAllCountries error`() = runBlocking {
        val errorResult = ResultWrapper.Error(Exception("Test error"))
        `when`(getAllCountriesUseCase(Unit)).thenReturn(flowOf(errorResult))

        viewModel.getAllCountries()

        val expectedState = CountriesState(error = "Test error")
        assertEquals(expectedState, viewModel.elektrobitCountries.value)
    }

    @Test
    fun `test getElectrobitLocationByCountryName success`() = runBlocking {
        val country = "Germany"
        val locations = listOf(
            Elektrobit(
                "Elektrobit Automotive GmbH",
                "Germany",
                "Erlangen",
                "Am Wolfsmantel 46",
                "+49 9131 7701 0",
                "+49 9131 7701 6333",
                "https://st.focusedcollection.com/14026668/i/650/focused_173592896-stock-photo-business-people-having-team-meeting.jpg"

            ), Elektrobit(
                "Branch München",
                "Germany",
                "München",
                "Georg-Brauchle-Ring 23",
                "+49 9131 7701 0",
                "+49 9131 7701 7850",
                "https://st.focusedcollection.com/9163412/i/650/focused_166152142-stock-photo-two-colleagues-looking-newspaper-while.jpg"

            )
        )
        val successResult = ResultWrapper.Success(locations)
        `when`(getLocationByCountryUseCase(country)).thenReturn(flowOf(successResult))

        viewModel.getElectrobitLocationByCountryName(country)

        val expectedState = ElektrobitState(locations = locations)
        assertEquals(expectedState, viewModel.elektrobitLocations.value)
    }

    @Test
    fun `test getElectrobitLocationByCountryName error`() = runBlocking {
        val country = "Germany"
        val errorResult = ResultWrapper.Error(Exception("Test error"))
        `when`(getLocationByCountryUseCase(country)).thenReturn(flowOf(errorResult))


        viewModel.getElectrobitLocationByCountryName(country)

        val expectedState = ElektrobitState(error = "Test error")
        assertEquals(expectedState, viewModel.elektrobitLocations.value)
    }
}
