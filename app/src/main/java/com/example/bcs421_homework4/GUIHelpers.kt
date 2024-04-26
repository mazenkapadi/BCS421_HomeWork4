package com.example.bcs421_homework4

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Composable function to display a heading.
 *
 * @param heading The text to be displayed as the heading.
 */
@Composable
fun DisplayHeading(heading: String) {
    // Box composable to center the heading text horizontally
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        // Text composable for displaying the heading text
        Text(
            text = heading,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 4.dp)
        )
    }
}

/**
 * Composable function to display normal text.
 *
 * @param text The text to be displayed.
 */
@Composable
fun DisplayNormalText(text: String) {
    // Text composable for displaying normal text
    Text(
        text = text,
        color = Color.Magenta,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}