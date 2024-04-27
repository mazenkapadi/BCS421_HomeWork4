package com.example.bcs421_homework4.Screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.bcs421_homework4.ViewModels.AddScreenViewModel
import com.example.bcs421_homework4.DisplayHeading
import com.example.bcs421_homework4.MyApp.Companion.salesRepository
import com.example.bcs421_homework4.Sale

/**
 * Composable function for adding a new sale.
 * @param navController The navigation controller to navigate between screens.
 */
@Composable
fun addScreen(navController: NavHostController) {

    // Accessing the current context
    val context = LocalContext.current

    // State for holding the name and amount of the sale
    var name by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }

    // ViewModel for adding a sale
    val addViewModel = viewModel { AddScreenViewModel(salesRepository) }

    // Surface composable for displaying the screen
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        // Column layout for arranging composables vertically
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
        ) {

            // Display heading for the screen
            DisplayHeading("Add Sales")

            // Text field for entering the name of the sale
            TextField(
                value = name,
                onValueChange = { newName ->
                    name = newName
                },
                label = {
                    Text("Name")
                },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
            )

            // Text field for entering the amount of the sale
            TextField(
                value = amount,
                onValueChange = { newAmount ->
                    amount = newAmount
                },
                label = {
                    Text("Amount")
                },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
            )

            // Button for adding the sale
            Button(onClick = {
                // Convert amount to double
                val amountDouble = amount.toDouble()
                // Add sale using the ViewModel
                addViewModel.addSale(Sale(name, amountDouble))
                // Show a toast message indicating that the sale has been added
                Toast.makeText(context, "Sale added", Toast.LENGTH_SHORT).show()
                // Reset name and amount fields
                name = ""
                amount = ""
            }) {
                Text("Add Sale")
            }
        }
    }
}
