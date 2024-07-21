package com.latihan.valorantapp.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.latihan.valorantapp.R
import com.latihan.valorantapp.utils.shouldShowBottomBar

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val screens = listOf(
        Screens.Home,
        Screens.Search,
        Screens.Person,
    )
    AnimatedVisibility(visible = currentRoute.shouldShowBottomBar()) {
        NavigationBar(
            contentColor = Color.Transparent,
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    navHostController = navHostController,
                    currentRoute = currentRoute
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    modifier: Modifier = Modifier,
    screen: Screens,
    navHostController: NavHostController,
    currentRoute: String?
) {
    NavigationBarItem(
        label = {
            Text(
                text = screen.label ?: "",
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 11.sp
            )
        },
        selected = currentRoute == screen.route,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.id)
                launchSingleTop = true
            }
        },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon!!),
                contentDescription = null
            )
        }
    )
}
