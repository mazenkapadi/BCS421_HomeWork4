package com.example.bcs421_homework4

import androidx.compose.ui.graphics.vector.ImageVector

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
