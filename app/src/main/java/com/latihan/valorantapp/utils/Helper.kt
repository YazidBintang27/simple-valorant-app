package com.latihan.valorantapp.utils

import com.latihan.valorantapp.navigation.Screens

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screens.Home.route,
        Screens.Search.route,
        Screens.Person.route
    )
}