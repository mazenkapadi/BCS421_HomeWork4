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
import androidx.compose.ui.graphics.vector.ImageVector
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

/**
 * Class representing an item in the navigation bar.
 * @property title The title of the navigation item.
 * @property route The route associated with the navigation item.
 * @property iconSelected The selected icon for the navigation item.
 * @property iconUnselected The unselected icon for the navigation item.
 * @constructor Creates a MyNavItem object with provided properties.
 */
class MyNavItem(
    val title: String,
    val route: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector
) {
    // Variables have been declared in primary constructor
}