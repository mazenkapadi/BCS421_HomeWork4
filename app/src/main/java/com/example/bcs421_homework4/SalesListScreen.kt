package com.example.bcs421_homework4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

/**
 * Composable function for the home screen displaying the list of sales.
 * @param navController The navigation controller.
 */
@Composable
fun homeScreen(navController: NavHostController) {
    // ViewModel for managing the list of sales
    val salesListViewModel = viewModel { SalesListViewModel(MyApp.salesRepository) }
    // Collecting the list of sales as state from the ViewModel
    val queryState = salesListViewModel.salesFlow.collectAsState(initial = emptyList())
    val salesList = queryState.value

    // Surface composable for displaying the screen
    Surface(
        modifier = Modifier
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column {
            // Displaying the heading for the sales list
            DisplayHeading(heading = "Sales List")
            // LazyColumn for efficiently displaying a list of items
            LazyColumn(modifier = Modifier.padding(20.dp)) {
                // Iterating over the list of sales and displaying each sale item
                items(salesList.size) { index ->
                    DisplaySaleItem(salesList[index])
                }
            }
        }
    }
}

/**
 * Composable function for displaying a single sale item.
 * @param sale The sale object to be displayed.
 */
@Composable
fun DisplaySaleItem(sale: Sale) {
    // Surface composable for styling the sale item
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 12.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Displaying the name of the sale
            DisplayNormalText(text = sale.name)
            // Displaying the amount of the sale
            DisplayNormalText(text = sale.amount.toString())
        }
    }
}
