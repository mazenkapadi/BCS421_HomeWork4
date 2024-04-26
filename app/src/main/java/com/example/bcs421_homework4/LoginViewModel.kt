package com.example.bcs421_homework4

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 * ViewModel class for handling login functionality.
 */
class LoginViewModel : ViewModel() {
    /**
     * Initiates Firebase authentication process.
     * @param email The email entered by the user.
     * @param password The password entered by the user.
     * @param successfulLoginHandler The callback function to be called on successful login.
     * @param unsuccessfulLoginHandler The callback function to be called on unsuccessful login.
     */
    fun loginFirebase(
        email: String,
        password: String,
        successfulLoginHandler: () -> Unit,
        unsuccessfulLoginHandler: () -> Unit
    ) {
        // Getting instance of FirebaseAuth
        var firebaseAuth = FirebaseAuth.getInstance()
        // Launching a coroutine within the viewModelScope
        viewModelScope.launch {
            try {
                // Attempting to sign in with email and password
                firebaseAuth.signInWithEmailAndPassword(email, password).await()
                // Calling successful login handler on successful login
                successfulLoginHandler()
            } catch (e: Exception) {
                // Calling unsuccessful login handler if an exception occurs during login
                unsuccessfulLoginHandler()
            }
        }
    }
}