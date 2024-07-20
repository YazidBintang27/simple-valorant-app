package com.latihan.valorantapp.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.latihan.valorantapp.R

sealed class Screens(
    val route: String,
    val label: String?,
    val icon: Int?
) {
    data object Home: Screens("home", "Home", R.drawable.home_11_stroke_rounded)
    data object Search: Screens("search", "Search", R.drawable.search_01_stroke_rounded)
    data object Person: Screens("profile", "Profile", R.drawable.user_stroke_rounded)
    data object Detail: Screens("detail", null, null)
    data object Splash: Screens("splash", null, null)
}