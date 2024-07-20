package com.latihan.valorantapp.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.latihan.valorantapp.R
import com.latihan.valorantapp.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    SplashContent(navHostController = navHostController)
}

@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    LaunchedEffect(key1 = true) {
        delay(2000)
        navHostController.navigate(Screens.Home.route) {
            popUpTo(Screens.Splash.route) {
                inclusive = true
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.valorant_logo),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
    }
}
