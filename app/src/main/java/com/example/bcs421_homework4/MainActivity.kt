package com.example.bcs421_homework4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bcs421_homework4.ui.theme.BCS421_HomeWork4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BCS421_HomeWork4Theme {
                RootScreen()
            }
        }
    }
}