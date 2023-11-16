package com.example.mydiscountapp.views


import kotlin.math.round
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.mydiscountapp.components.*
import com.example.mydiscountapp.viewModel.CalculateViewModel
import com.example.mydiscountapp.viewModel.CalculateViewModel2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView2(viewModel: CalculateViewModel2){
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = { CenterAlignedTopAppBar( title = { Text(text = "Descuentos") }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor= MaterialTheme.colorScheme.primary
        )) }) {
        ContentHomeView2(it, viewModel)
    }
}
@Composable
fun ContentHomeView2(paddingValues: PaddingValues, viewModel: CalculateViewModel2){
    Column(modifier = Modifier
        .padding(paddingValues)
        .padding(top = 30.dp)
        .fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {

        HeaderTitle("Empieza a calcular")
        SpaceHeight()
        MainTextField(value = viewModel.price, onChangeValue = {viewModel.onValuePrice(it)}, label = "Precio")
        SpaceHeight()
        MainTextField(value = viewModel.discount, onChangeValue = { viewModel.onValueDiscount(it)}, label = "Descuento")
        GridWithColumns(
            items = listOf(
                { MainCard(title = "Precio", number = viewModel.priceWithDiscount, modifier= Modifier.testTag("price-card").fillMaxWidth()) },
                { MainCard(title = "Descuento", number = viewModel.totalDiscount,modifier= Modifier.testTag("discount-card").fillMaxWidth()) }
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
        }
        SpaceHeight(5.dp)
        MainButton(text = "Limpiar", color=MaterialTheme.colorScheme.secondary) {
            viewModel.onValuePrice("")
            viewModel.onValueDiscount("")
            viewModel.onValuePriceWithDiscount(0.0)
            viewModel.onValueTotalDiscount(0.0)
        }
        SpaceHeight(30.dp)
        if(viewModel.showAlert){
            CenteredAlertDialog(
                title = "¡Alerta!",
                content = "Esto es un mensaje de alerta importante.",
                buttonText = "Cerrar"
            ) {
                viewModel.onValueShowAlert(false)
            }
        }

    }
}

/*
fun calculatePrice(price: Double, discount: Double): Double {
    val discountedPrice = calculateDiscount(price, discount)
    return round(price - discountedPrice)
}

fun calculateDiscount(price: Double, discount: Double): Double {
    val discountedAmount = price * (discount / 100)
    return round(discountedAmount)
}
*/
