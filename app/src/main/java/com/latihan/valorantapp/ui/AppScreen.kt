package com.latihan.valorantapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.latihan.valorantapp.navigation.BottomBar
import com.latihan.valorantapp.navigation.NavGraph

@Composable
fun AppScreen(
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navHostController)
        }
    ) { innerPadding ->
        NavGraph(navHostController = navHostController, modifier = Modifier.padding(innerPadding))
    }
}