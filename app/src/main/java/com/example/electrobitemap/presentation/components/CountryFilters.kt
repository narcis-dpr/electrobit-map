package com.example.electrobitemap.presentation.components

import android.content.res.Resources.Theme
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FilterBar(items: List<String>, onShowFilters: () -> Unit) {
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
        items(items) { item ->
            FilterChip(title = item)
        }
    }
}

@Composable
fun FilterChip(
    title: String
) {
    var selectValue = false
    var setSelectValue = false
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()
    val backgroundPressed by animateColorAsState(
        if (pressed) {
            Color.Green
        } else {
            Color.LightGray
        }
    )
    val border = if (pressed) {
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
                onValueChange = { !selectValue }
            )
//            .toggleable(
//                value = selectValue,
//                onValueChange = {
//                    println(" the first value is $selectValue ")
//                    selectValue = !selectValue
//                    println(" the second value is $selectValue")
//                },
//                interactionSource = interactionSource
//            )
            .clip(RoundedCornerShape(25))
            .wrapContentWidth()
            .height(40.dp)
            .then(Modifier.background(color = backgroundPressed))
            .then(border)
    ) {
        Text(
            text = title,
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
    FilterChip(title = "Germany")
}