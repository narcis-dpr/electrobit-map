package com.example.electrobitemap.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.electrobitemap.data.model.Elektrobit

@Composable
fun BottomCardView(elektrobits : List<Elektrobit>) {

}

@Composable
fun ElectroInfoCard(elektrobit: Elektrobit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(size = 20.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = elektrobit.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(8.dp)
            )
            Row() {
                Column(modifier = Modifier.weight(0.8f)) {
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
                Column(modifier = Modifier.weight(0.8f)) {
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
    ElectroInfoCard(elektrobit = elektrobit)
}