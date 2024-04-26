package com.example.bcs421_homework4

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Composable function for the login screen.
 * @param navController The navigation controller.
 */
@Composable
fun loginScreen(navController: NavHostController) {
    // State for holding email and password input values
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    // ViewModel for handling login logic
    val loginViewModel = viewModel { LoginViewModel() }
    // Context for displaying toast messages
    val context = LocalContext.current

    // Coroutine scope for launching coroutines
    val viewModelScope = rememberCoroutineScope()

    // Surface composable for displaying the screen
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 30.dp
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
        ) {
            // Displaying the heading for the login screen
            DisplayHeading("Login")
            // Text field for entering email
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth()
            )
            // Text field for entering password
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text("Password") },
                modifier = Modifier
                    .padding(vertical = 4.dp)
                    .fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
            // Button for initiating the login process
            Button(
                onClick = {
                    // Initiating login process using ViewModel
                    loginViewModel.loginFirebase(
                        email,
                        password,
                        { navController.navigate("homeScreen") }, // Navigating to home screen on successful login
                        {
                            // Handling login failure
                            viewModelScope.launch(Dispatchers.Main) {
                                // Displaying toast message for login failure
                                Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Login")
            }
        }
    }
}