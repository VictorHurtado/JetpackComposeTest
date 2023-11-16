package com.example.mydiscountapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.round

class CalculateViewModel2: ViewModel() {
    var price by mutableStateOf("")
        private set

    var discount by mutableStateOf("")
        private set

    var showAlert by mutableStateOf(true)
        private set
    var priceWithDiscount by mutableStateOf(0.0)
        private set
    var totalDiscount by mutableStateOf(0.0)
        private set


    fun onValuePrice(value: String){
        price = value
    }
    fun onValueDiscount(value: String){
        discount = value
    }
    fun onValueShowAlert(value: Boolean){
        showAlert = value
    }
    fun onValuePriceWithDiscount(value: Double){
        priceWithDiscount = value
    }

    fun onValueTotalDiscount (value: Double){
        totalDiscount=value
    }


    fun calculate(price: String, discount: String) {

        if(price != "" && discount != ""){
            priceWithDiscount = calculatePrice(
                price.toDouble(),
                discount.toDouble()
            )
            totalDiscount= calculateDiscount(
                price.toDouble(),
                discount.toDouble()
            )
        }else{
            showAlert=true
        }

    }
    private fun calculatePrice(price: Double, discount: Double): Double {
        val discountedPrice = calculateDiscount(price, discount)
        return round(price - discountedPrice)
    }

    private fun calculateDiscount(price: Double, discount: Double): Double {
        val discountedAmount = price * (discount / 100)
        return round(discountedAmount)
    }


}