package com.example.electrobitemap.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.electrobitemap.data.model.Elektrobit

@Composable
fun BottomCardView(elektrobits : List<Elektrobit>, modifier: Modifier = Modifier) {
  LazyRow(
      modifier = modifier,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      contentPadding = PaddingValues(start = 24.dp, top = 8.dp, end = 24.dp, bottom = 24.dp)
  ) {
      itemsIndexed(items = elektrobits) { index, item ->
         ElectroInfoCard(elektrobit = item)
      }
  }
}

@Composable
fun ElectroInfoCard(elektrobit: Elektrobit) {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .clip(RoundedCornerShape(size = 20.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Text(
                text = elektrobit.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(2.dp)

            )
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.wrapContentSize()) {
                Row(modifier = Modifier.padding(2.dp)) {
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(
                        text = elektrobit.country,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = elektrobit.city,
                        style = MaterialTheme.typography.body2,
                        maxLines = 3
                    )
                    Text(
                        text = elektrobit.address,
                        style = MaterialTheme.typography.body2,
                        maxLines = 3
                    )
                }
                Column(modifier = Modifier.padding(2.dp)) {
                    Text(
                        text = elektrobit.tel,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = elektrobit.fax,
                        style = MaterialTheme.typography.body2,
                        maxLines = 3
                    )
                }
            }
            }
        }
    }
}

@Preview
@Composable
fun showCard(){
    val elektrobit : Elektrobit = Elektrobit(
        name = "Elektrobit Automotive GmbH",
        address = "Am Wolfsmantel 46",
        country = "Germany",
        city = "Erlangen",
        tel = "+49 9131 7701 0",
        fax = "+49 9131 7701 6333"
    )
    val electrobits = listOf(
        Elektrobit(
            name = "Elektrobit Automotive GmbH",
            address = "Am Wolfsmantel 46",
            country = "Germany",
            city = "Erlangen",
            tel = "+49 9131 7701 0",
            fax = "+49 9131 7701 6333"
        ),
        Elektrobit(
            name = "Elektrobit Automotive GmbH",
            address = "Am Wolfsmantel 46",
            country = "Germany",
            city = "Erlangen",
            tel = "+49 9131 7701 0",
            fax = "+49 9131 7701 6333"
        ),
        Elektrobit(
            name = "Elektrobit Automotive GmbH",
            address = "Am Wolfsmantel 46",
            country = "Germany",
            city = "Erlangen",
            tel = "+49 9131 7701 0",
            fax = "+49 9131 7701 6333"
        )
    )
 // ElectroInfoCard(elektrobit = elektrobit)
    BottomCardView(electrobits, Modifier.size(400.dp))
}