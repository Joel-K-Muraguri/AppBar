package com.example.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen
    (
    val route : String,
    val icons : ImageVector,
    val title : String
            )
{
    object Home:Screen
            (
            route = "home_route",
            icons = Icons.Filled.Home,
            title = "Home"
        )
    object Search:Screen
        (
        route = "search_route",
        icons = Icons.Filled.Search,
        title = "Search"
    )
    object Favourite:Screen
        (
        route = "favourite_route",
        icons = Icons.Filled.Favorite,
        title = "Favourite"
    )
    object Message : Screen
        (
        route = "message_route",
        icons = Icons.Filled.Email,
        title = "Message"

    )
    object Person:Screen
        (
        route = "person_route",
        icons = Icons.Filled.Person,
        title = "Message"
    )
    object Settings:Screen
        (
        route = "settings_route",
        icons = Icons.Filled.Settings,
        title = "Message"
    )
    object Shopping:Screen
        (
        route = "shopping_route",
        icons = Icons.Filled.ShoppingCart,
        title = "Message"
    )
    object Rate:Screen
        (
        route = "email_route",
        icons = Icons.Filled.ThumbUp,
        title = "Rate"
    )





}
