package com.latihan.valorantapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.ui.theme.ValorantAppTheme

@Composable
fun AgentCard(
    modifier: Modifier = Modifier,
    agentData: List<AgentModel.Data?>,
    index: Int
) {
    AgentCartContent(
        modifier = modifier,
        agentData = agentData,
        index = index
    )
}

@Composable
fun AgentCartContent(
    modifier: Modifier,
    agentData: List<AgentModel.Data?>,
    index: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(300.dp)
            .padding(20.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp))
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = agentData[index]?.background),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = rememberAsyncImagePainter(model = agentData[index]?.fullPortraitV2),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AgentCardPreview() {
    ValorantAppTheme {

    }
}
