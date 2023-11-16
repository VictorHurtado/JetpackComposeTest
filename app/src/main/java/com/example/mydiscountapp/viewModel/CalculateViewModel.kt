package com.example.mydiscountapp.viewModel

import androidx.lifecycle.ViewModel
import kotlin.math.round

class CalculateViewModel: ViewModel() {

    fun calculate(price: String, discount: String): Pair<Double,Pair<Double, Boolean>> {
        var priceWithDiscount =0.0
        var totalDiscount = 0.0
        var showALert= false
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
            showALert=true
        }
        return Pair(priceWithDiscount,Pair(totalDiscount,showALert))
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