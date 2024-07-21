package com.latihan.valorantapp.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.latihan.valorantapp.R
import com.latihan.valorantapp.ui.components.AgentCard
import com.latihan.valorantapp.viewmodel.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(start = 20.dp, end = 50.dp),
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.valorant_logo),
                            contentDescription = "Logo",
                            modifier = Modifier.width(50.dp)
                        )
                    }
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.menu_24px),
                        contentDescription = "Menu Icon",
                    )
                }
            )
        }
    ) { innerPadding ->
        HomeContent(
            modifier = modifier.padding(innerPadding),
            navHostController = navHostController
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val agentData by homeViewModel.agentData.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp)
    ) {
        Text(
            text = "CHOOSE YOUR AGENT",
            fontSize = 32.sp,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Find more ways to plant the Spike and style on your enemies with scrappers, strategies, and hunters of every description",
            fontFamily = FontFamily(Font(R.font.poppins_bold)),
            fontSize = 12.sp,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        if (agentData.isEmpty()) {
            CircularProgressIndicator()
        } else {
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(agentData.size) { index->
                    AgentCard(
                        agentData = agentData,
                        index = index,
                        navHostController = navHostController
                    )
                }
            }
        }
    }
}