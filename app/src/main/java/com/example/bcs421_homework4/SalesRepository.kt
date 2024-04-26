package com.example.bcs421_homework4

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow

/**
 * Repository class for managing sales data.
 * @property firestoreDb Instance of FirebaseFirestore used for database operations.
 */
class SalesRepository(
    var firestoreDb: FirebaseFirestore
) {

    /**
     * Retrieves all sales data from the Firestore database.
     * @return Flow representing the list of sales.
     */
    fun getAllSales(): Flow<List<Sale>> {
        // Querying Firestore collection for all sales data and converting it to a Flow
        val queryFlow: Flow<List<Sale>> =
            firestoreDb.collection("Hwk4Sales").dataObjects<Sale>()
        return queryFlow
    }

    /**
     * Adds a new sale to the Firestore database.
     * @param sale The sale object to be added.
     */
    fun addSale(sale: Sale) {
        // Adding the sale object to the Firestore collection
        firestoreDb.collection("Hwk4Sales")
            .add(sale)
            .addOnSuccessListener { documentReference ->
                println("DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                println("Error adding document $e")
            }
    }
}
