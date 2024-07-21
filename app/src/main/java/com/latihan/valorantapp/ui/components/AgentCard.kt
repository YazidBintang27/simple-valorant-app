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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import android.graphics.Color.parseColor
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.latihan.valorantapp.models.AgentModel
import com.latihan.valorantapp.navigation.Screens
import com.latihan.valorantapp.ui.theme.ValorantAppTheme

@Composable
fun AgentCard(
    modifier: Modifier = Modifier,
    agentData: List<AgentModel.Data?>,
    index: Int,
    navHostController: NavHostController
) {
    AgentCartContent(
        modifier = modifier,
        agentData = agentData,
        index = index,
        navHostController = navHostController
    )
}

@Composable
fun AgentCartContent(
    modifier: Modifier,
    agentData: List<AgentModel.Data?>,
    index: Int,
    navHostController: NavHostController
) {
    val gradientColors = agentData[index]?.backgroundGradientColors?.map { colors ->
       Color(parseColor("#$colors"))
    } ?: listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(280.dp)
                .padding(start = 20.dp, end = 20.dp , bottom = 8.dp, top = 20.dp)
                .background(
                    brush = Brush.linearGradient(gradientColors),
                    shape = RoundedCornerShape(topStart = 20.dp, bottomEnd = 20.dp)
                )
                .clickable {
                    navHostController.navigate("${Screens.Detail.route}/$index") {
                        popUpTo(Screens.Detail.route) {
                            inclusive = true
                        }
                    }
                }
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
        Text(
            text = agentData[index]?.displayName ?: "",
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AgentCardPreview() {
    ValorantAppTheme {

    }
}
