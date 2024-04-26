package com.example.bcs421_homework4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

/**
 * ViewModel class for managing the list of sales.
 * @property salesRepository Instance of SalesRepository for handling database operations.
 * @property salesFlow Flow representing the list of sales.
 */
class SalesListViewModel(
    private val salesRepository: SalesRepository
) : ViewModel() {
    // Flow representing the list of sales
    var salesFlow = getAllSales()

    /**
     * Retrieves all sales from the repository as a Flow.
     * @return Flow representing the list of sales.
     */
    fun getAllSales(): Flow<List<Sale>> {
        // Delegates the call to the salesRepository
        return salesRepository.getAllSales()
    }
}