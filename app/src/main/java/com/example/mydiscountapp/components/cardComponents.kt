package com.example.mydiscountapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mydiscountapp.ui.theme.NeutralGray
import com.example.mydiscountapp.ui.theme.NeutralWhite


@Composable
fun GridWithColumns(
    items: List<@Composable () -> Unit>,
    columns: Int
) {
    val rows = items.chunked(columns)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 30.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        for (rowItems in rows) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                for (item in rowItems) {
                    Box(modifier = Modifier.weight(1f)){
                        item()

                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCard (title: String, number: Double,modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        colors= CardDefaults.cardColors(
            containerColor = NeutralGray
        )
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(vertical = 30.dp)) {
            Text(text = title, color= MaterialTheme.colorScheme.secondary, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            Text(text = "$${number}", color= NeutralWhite, fontSize = 20.sp,textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }
}