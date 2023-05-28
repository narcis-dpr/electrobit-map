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
import com.google.android.gms.maps.GoogleMap
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen() {
    val scaffoldState = rememberScaffoldState()
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = true,
            scrollGesturesEnabledDuringRotateOrZoom = true)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
            modifier = Modifier) {
                Icon(imageVector = Icons.Default.ToggleOff, contentDescription = "")
            }
        },
        bottomBar = {

        }) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
           // properties = viewModel.state.properties,
            uiSettings = uiSettings,
            onMapLongClick = {
              //  viewModel.onEvent(MapEvent.OnMapLongClick(it))
            }
        ) {
            FloatingActionButton(onClick = { /*TODO*/ },) {
            }
        }
    }
}