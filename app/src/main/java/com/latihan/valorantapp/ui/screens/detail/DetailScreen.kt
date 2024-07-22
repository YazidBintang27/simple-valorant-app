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
import com.latihan.valorantapp.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    index: Int?
) {
    DetailContent(index = index)
}

@Composable
fun DetailContent(index: Int?) {

    val detailViewModel: DetailViewModel = hiltViewModel()
    val agentByIndex by detailViewModel.agentByIndex.collectAsState()

    LaunchedEffect(agentByIndex) {
        detailViewModel.getAgentByIndex(index!!)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = agentByIndex?.displayName ?: "")
    }
}
