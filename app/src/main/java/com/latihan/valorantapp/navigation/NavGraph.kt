package com.latihan.valorantapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaN
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.latihan.valorantapp.ui.screens.detail.DetailScreen
import com.latihan.valorantapp.ui.screens.home.HomeScreen
import com.latihan.valorantapp.ui.screens.profile.ProfileScreen
import com.latihan.valorantapp.ui.screens.search.SearchScreen
import com.latihan.valorantapp.ui.screens.splash.SplashScreen

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.Splash.route
    ) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
        composable(Screens.Search.route) {
            SearchScreen()
        }
        composable(Screens.Person.route) {
            ProfileScreen()
        }
        composable(Screens.Detail.route) {
            DetailScreen()
        }
        composable(Screens.Splash.route) {
            SplashScreen(navHostController = navHostController)
        }
    }
}