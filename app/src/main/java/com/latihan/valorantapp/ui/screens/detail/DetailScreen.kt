package com.latihan.valorantapp.ui.screens.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.latihan.valorantapp.viewmodel.HomeViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    index: Int?
) {
    DetailContent(index = index)
}

@Composable
fun DetailContent(index: Int?) {

    val homeViewModel: HomeViewModel = hiltViewModel()
    val agentData by homeViewModel.agentData.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = agentData[index!!]?.displayName ?: "")
    }
}
