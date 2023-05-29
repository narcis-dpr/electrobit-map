package com.example.electrobitemap.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.electrobitemap.data.model.Elektrobit
import com.example.electrobitemap.presentation.components.BottomCardView
import com.example.electrobitemap.presentation.components.FilterBar
import com.example.electrobitemap.presentation.state.CountryFilter
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen() {
    val scaffoldState = rememberScaffoldState()
    val electrobits = listOf(Elektrobit(name = "Elektrobit Automotive GmbH", address = "Am Wolfsmantel 46", country = "Germany", city = "Erlangen", tel = "+49 9131 7701 0", fax = "+49 9131 7701 6333"),
        Elektrobit(name = "Elektrobit Automotive GmbH", address = "Am Wolfsmantel 46", country = "Germany", city = "Erlangen", tel = "+49 9131 7701 0", fax = "+49 9131 7701 6333", Image = ""))
    val countires = listOf(CountryFilter("Germany", selected = true), CountryFilter("Germany", selected = true), CountryFilter("Italy", selected = false), CountryFilter("India", selected = false))
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false, scrollGesturesEnabledDuringRotateOrZoom = true)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
            modifier = Modifier) {
                Icon(imageVector = Icons.Default.ToggleOff, contentDescription = "")
            }
        },
        topBar = {
            FilterBar(items = countires) {

            }
        },
        bottomBar = {
            BottomCardView(elektrobits = electrobits)
        }
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
           // properties = viewModel.state.properties,
            uiSettings = uiSettings,

        )  {
           // FloatingActionButton(onClick = { /*TODO*/ },) {
            }
        }
}