package com.example.electrobitemap.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.presentation.components.BottomCardView
import com.example.electrobitemap.presentation.components.FilterBar
import com.example.electrobitemap.presentation.event.FilterEvent
import com.example.electrobitemap.presentation.viewModel.ElectrobitLocationViewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen(electrobitLocationViewModel: ElectrobitLocationViewModel) {
    val scaffoldState = rememberScaffoldState()
    val electrobits = listOf(Elektrobit(name = "Elektrobit Automotive GmbH", address = "Am Wolfsmantel 46", country = "Germany", city = "Erlangen", tel = "+49 9131 7701 0", fax = "+49 9131 7701 6333"),
        Elektrobit(name = "Elektrobit Automotive GmbH", address = "Am Wolfsmantel 46", country = "Germany", city = "Erlangen", tel = "+49 9131 7701 0", fax = "+49 9131 7701 6333", image = ""))
    val countires = listOf("Germany", "Germany", "Italy","India")
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false, scrollGesturesEnabledDuringRotateOrZoom = true)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                electrobitLocationViewModel.onFilterEvent(FilterEvent.ToggleFalloutMap)
            },
            modifier = Modifier) {
                Icon(imageVector = Icons.Default.ToggleOff, contentDescription = "")
                Icon(
                    imageVector = if (electrobitLocationViewModel.state.isFalloutMap) {
                        Icons.Default.ToggleOff
                    } else Icons.Default.ToggleOn,
                    contentDescription = "Toggle map"
                )

            }
        },
        topBar = {
            FilterBar(countries = electrobitLocationViewModel.elektrobitCountries.value, electrobitLocationViewModel) {

            }
        },
        bottomBar = {
            BottomCardView(elektrobits = electrobitLocationViewModel.elektrobitLocations.value)
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            properties = electrobitLocationViewModel.state.properties,
            uiSettings = uiSettings,

        )  {
           // FloatingActionButton(onClick = { /*TODO*/ },) {
            }
        }
}