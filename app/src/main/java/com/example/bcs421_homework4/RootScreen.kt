package com.example.bcs421_homework4

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/**
 * Composable function for the root screen.
 */
@Composable
fun RootScreen() {
    // List of navigation items
    val navItemsList = listOf(
        MyNavItem(
            title = "Home",
            route = "homeScreen",
            iconSelected = Icons.Filled.Home,
            iconUnselected = Icons.Outlined.Home
        ),
        MyNavItem(
            title = "Add",
            route = "addScreen",
            iconSelected = Icons.Filled.Add,
            iconUnselected = Icons.Outlined.Add
        )
    )

    // Navigation controller
    var navController: NavHostController = rememberNavController()
    // Index of the selected navigation item
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    // State for controlling the visibility of bars
    var showBars by rememberSaveable { mutableStateOf(false) }

    // Scaffold composable for the screen layout
    Scaffold(
        topBar = {
            if (showBars) {
                myTopAppBar(navController) { index ->
                    selectedItemIndex = index
                }
            }
        },
        floatingActionButton = {
            if (showBars) {
                myFAB(navController) { index ->
                    selectedItemIndex = index
                }
            }
        },
        bottomBar = {
            if (showBars) {
                NavigationBar {
                    // Rendering navigation items
                    navItemsList.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = (selectedItemIndex == index),
                            onClick = {
                                selectedItemIndex = index
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                }
                            },
                            label = { Text(item.title) },
                            icon = {
                                Icon(
                                    contentDescription = item.title,
                                    imageVector = if (selectedItemIndex == index) item.iconSelected
                                    else item.iconUnselected
                                )
                            }
                        )
                    }
                }
            }
        },
    ) { padding ->
        // Column layout for arranging composables vertically
        Column(
            modifier = Modifier.padding(padding)
        ) {
            // Navigation host for managing navigation between screens
            NavHost(navController, "loginScreen") {
                // Defining composable for each destination screen
                composable("loginScreen") {
                    loginScreen(navController)
                    showBars = false
                }
                composable("addScreen") {
                    addScreen(navController)
                    showBars = true
                }
                composable("homeScreen") {
                    homeScreen(navController)
                    showBars = true
                }
            }
        }
    }
}

/**
 * Top App Bar composable.
 * @param navController The navigation controller.
 * @param setSelectedItemIndex Callback function to set the selected item index.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopAppBar(navController: NavController, setSelectedItemIndex: (Int) -> Unit) {
    // State for controlling the visibility of the menu
    var showMenu by remember { mutableStateOf(false) }

    // Top App Bar composable
    CenterAlignedTopAppBar(
        title = { DisplayHeading("Sales App") },
        actions = {
            // IconButton for showing the menu
            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(Icons.Default.MoreVert, null)
            }
            // Dropdown menu for additional options
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                // Dropdown menu items
                DropdownMenuItem(
                    text = { Text("Sales List") },
                    onClick = {
                        showMenu = false
                        navController.navigate("homeScreen")
                        setSelectedItemIndex(0)
                    },
                    leadingIcon = { Icon(Icons.Outlined.List, null) }
                )
                DropdownMenuItem(
                    text = { Text("Add Sale") },
                    onClick = {
                        showMenu = false
                        navController.navigate("addScreen")
                        setSelectedItemIndex(1)
                    },
                    leadingIcon = { Icon(Icons.Filled.Add, null) }
                )
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        showMenu = false
                        navController.navigate("loginScreen")
                    },
                    leadingIcon = { Icon(Icons.Outlined.Lock, null) }
                )
            }
        }
    )
}

/**
 * Floating Action Button composable.
 * @param navController The navigation controller.
 * @param setSelectedItemIndex Callback function to set the selected item index.
 */
@Composable
fun myFAB(navController: NavController, setSelectedItemIndex: (Int) -> Unit) {
    // Floating Action Button for adding a new sale
    FloatingActionButton(
        onClick = {
            navController.navigate("addScreen")
            setSelectedItemIndex(1)
        },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}
