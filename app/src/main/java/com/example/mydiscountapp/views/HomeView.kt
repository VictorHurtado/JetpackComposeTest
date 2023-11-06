package com.example.mydiscountapp.views

import kotlin.math.round
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mydiscountapp.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { CenterAlignedTopAppBar( title = { Text(text = "Descuentos") }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor= MaterialTheme.colorScheme.primary
    )) }) {
        ContentHomeView(it)
    }
}
@Composable
fun ContentHomeView(paddingValues: PaddingValues){
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(top = 30.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
            var price by remember{ mutableStateOf("") }
            var discount by remember{ mutableStateOf("") }
            var priceWithDiscount by remember{ mutableStateOf<Double>( 0.0) }
            var totalDiscount by remember{ mutableStateOf<Double>( 0.0) }
            var showALert by remember{ mutableStateOf<Boolean>( false) }
            HeaderTitle("Empieza a calcular")
            SpaceHeight()
            MainTextField(value = price, onChangeValue = { price = it}, label = "Precio")
            SpaceHeight()
            MainTextField(value = discount, onChangeValue = { discount = it}, label = "Descuento")
            GridWithColumns(
                items = listOf(
                    { MainCard(title = "Precio", number = priceWithDiscount, modifier= Modifier.fillMaxWidth()) },
                    { MainCard(title = "Descuento", number = totalDiscount,modifier= Modifier.fillMaxWidth()) }
                ),
                3
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(16.dp)
            ) {

            }
            MainButton(text = "Calcular") {
                if(price != "" && discount != ""){
                    priceWithDiscount = calculatePrice(price.toDouble(), discount.toDouble())
                    totalDiscount= calculateDiscount(price.toDouble(), discount.toDouble())
                }else{
                    showALert=true
                }

            }
            SpaceHeight(5.dp)
            MainButton(text = "Limpiar", color=MaterialTheme.colorScheme.secondary) {
                price=""
                discount=""
                priceWithDiscount=0.0
                totalDiscount=0.0
            }
            SpaceHeight(30.dp)
            if(showALert){
                CenteredAlertDialog(
                    title = "¡Alerta!",
                    content = "Esto es un mensaje de alerta importante.",
                    buttonText = "Cerrar"
                ) {
                    showALert=false
                }
            }

    }
}


fun calculatePrice(price: Double, discount: Double): Double {
    val discountedPrice = calculateDiscount(price, discount)
    return round(price - discountedPrice)
}

fun calculateDiscount(price: Double, discount: Double): Double {
    val discountedAmount = price * (discount / 100)
    return round(discountedAmount)
}

