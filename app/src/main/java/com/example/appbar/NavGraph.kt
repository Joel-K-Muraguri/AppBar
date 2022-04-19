package com.example.appbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen()
        }
        composable(route = Screen.Search.route){
            SearchScreen()
        }
        composable(route = Screen.Favourite.route){
            FavouriteScreen()
        }
        composable(route = Screen.Message.route){
            MessageScreen()
        }

    }

}

@Preview(showBackground = true)
@Composable
fun NavGraphPreview(){

}