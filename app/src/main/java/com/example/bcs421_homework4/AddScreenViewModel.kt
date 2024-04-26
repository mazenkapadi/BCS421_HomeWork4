package com.example.bcs421_homework4

import androidx.lifecycle.ViewModel

/**
 * ViewModel class for managing operations related to adding a sale.
 * @property salesRepository Instance of SalesRepository for handling database operations.
 */
class AddScreenViewModel(
    private val salesRepository: SalesRepository
) : ViewModel() {

    /**
     * Adds a new sale to the database.
     * @param sale The sale object to be added.
     */
    fun addSale(sale: Sale) {
        salesRepository.addSale(sale)
    }
}
