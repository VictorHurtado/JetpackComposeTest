package com.example.mydiscountapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.mydiscountapp.ui.theme.MyDiscountAppTheme
import com.example.mydiscountapp.viewModel.CalculateViewModel
import com.example.mydiscountapp.viewModel.CalculateViewModel2
import com.example.mydiscountapp.views.HomeView
import com.example.mydiscountapp.views.HomeView2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel : CalculateViewModel2  by viewModels()
        setContent {
            MyDiscountAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeView2(viewModel)
                }
            }
        }
    }
}

