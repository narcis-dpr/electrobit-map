package com.example.electrobitemap.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.electrobitemap.presentation.event.FilterEvent
import com.example.electrobitemap.presentation.state.CountriesState
import com.example.electrobitemap.presentation.viewModel.ElectrobitLocationViewModel


@Composable
fun FilterBar(countries: CountriesState, viewModel: ElectrobitLocationViewModel, onShowFilters: () -> Unit) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 12.dp, end = 8.dp),
        modifier = Modifier
            .heightIn(min = 56.dp)
            .background(color = Color.Transparent)
    ) {
//        item {
//            IconButton(onClick = { onShowFilters }) {
//                Icon(imageVector = Icons.Rounded.FilterList,
//                    contentDescription = "item for filter list",
//                    tint = MaterialTheme.colorScheme.onSecondary,
//                    modifier = Modifier.diagonalGradientBorder(
//                        colors = listOf(MaterialTheme.colorScheme.onSecondaryContainer, MaterialTheme.colorScheme.onSecondary),
//                        shape = CircleShape
//                    )
//                )
//            }
//        }
        itemsIndexed(viewModel.elektrobitCountries.value.countries) {index, item ->
            FilterChip(title = item, viewModel)
        }
    }
}

@Composable
fun FilterChip(
    title: Pair<String, Boolean>,
    viewModel: ElectrobitLocationViewModel
) {
    var selectValue = false
    var setSelectValue = false
    val onclickVisibility = remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val backgroundPressed by animateColorAsState(
        if (onclickVisibility.value) {
            Color.Green
        } else {
            Color.LightGray
        }
    )
    val border = if (onclickVisibility.value) {
        Modifier.border(
            width = 2.dp,
            brush = Brush.linearGradient(listOf(Color.Yellow, Color.Green, Color.LightGray)),
            shape = RoundedCornerShape(25)
        )
    } else {
        Modifier.border(
            width = 10.dp,
            brush = Brush.linearGradient(listOf(Color.Transparent, Color.White, Color.LightGray)),
            shape = RoundedCornerShape(25)
        )
    }

    Box(
        modifier = Modifier
            .toggleable(
                interactionSource = interactionSource,
                value = selectValue,
                indication = null,
                onValueChange = { !selectValue
                    viewModel.onFilterEvent(FilterEvent.OnFilterClick(Pair(title.first, true)))}
            )
            .clip(RoundedCornerShape(25))
            .wrapContentWidth()
            .height(40.dp)
            .then(Modifier.background(color = backgroundPressed))
            .then(border)
            .clickable {
                viewModel.onFilterEvent(FilterEvent.OnFilterClick(Pair(title.first, true)))
                onclickVisibility.value = !onclickVisibility.value

            }
    ) {
        Text(
            text = title.first,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
                .clip(RoundedCornerShape(25))
        )
    }
}

@Preview
@Composable
fun showCountires() {
    //FilterChip(title = "Germany")
}