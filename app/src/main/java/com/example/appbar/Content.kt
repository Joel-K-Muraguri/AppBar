package com.example.appbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(){

    val navController = rememberNavController()
    Scaffold(
        topBar = {
                 TopBar()

        },
        bottomBar = {
            BottomBar(navController = navController)

        },


    ) {
        NavGraph(navController = navController)
    }

}
@Preview
@Composable
fun MainScreenPreview(){
    MainScreen()

}

@Composable
fun TopBar(){
    TopAppBar(
        title = {
                Text(text = "Top Navigation")
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White,


    )
}

@Composable
fun BottomBar(
    navController: NavHostController
){
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Favourite,
        Screen.Message
    )
     BottomAppBar(
         backgroundColor = Color.Blue,
         contentColor = Color.White


     ) {
         val navBackStackEntry by navController.currentBackStackEntryAsState()
         val currentDestination = navBackStackEntry?.destination

        BottomNavigation {
            items.forEach{ screen ->
                AddItems(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController

                )
            }
        }
     }
}

@Composable
fun RowScope.AddItems(
    screen : Screen,
    currentDestination : NavDestination?,
    navController: NavHostController

){
    BottomNavigationItem(
        icon = {
            Icon(imageVector = screen.icons, contentDescription = screen.title)

        },
        label = {
                Text(text = screen.title)
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color.White.copy(0.4f),
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        alwaysShowLabel = true,
        onClick = {
        navController.navigate(screen.route){
            navController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) {
                    saveState = true
                }
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true

        }
        }
    )
}

