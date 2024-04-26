package com.example.bcs421_homework4

import android.app.Application
import com.google.firebase.firestore.FirebaseFirestore

/**
 * Custom Application class for initializing global resources.
 */
class MyApp : Application() {
    companion object {
        // Static variable for accessing the sales repository instance
        lateinit var salesRepository: SalesRepository
            private set
    }

    /**
     * Called when the application is starting, initializes global resources.
     */
    override fun onCreate() {
        super.onCreate()
        // Initializing Firestore database instance
        val firestoreDb = FirebaseFirestore.getInstance()
        // Initializing sales repository with Firestore database instance
        salesRepository = SalesRepository(firestoreDb)
    }
}
