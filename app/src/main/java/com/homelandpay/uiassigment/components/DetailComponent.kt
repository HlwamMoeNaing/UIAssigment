package com.homelandpay.uiassigment.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun DetailImageSliderItem(imageRes: Int,onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageRes), contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .clickable {
                onClick()
            }
    )
}

@Composable
fun DetailIndicator(active: Boolean) {
    val color = if (active) Color.Red else Color.White
    val size = if (active) 20.dp else 20.dp
    Box(
        modifier = Modifier
            .height(8.dp)
            .width(25.dp)
            .clip(CircleShape)
            .background(color)

    )
}

@Composable
fun DetailImageSlideWithIndicator(images: List<Int>,onClick:()->Unit) {
    val currentIndex = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        while (true) {
            delay(2000)
            currentIndex.value = (currentIndex.value + 1) % images.size
        }
    }

    Box(
        modifier = Modifier.fillMaxWidth(),

        ) {
        DetailImageSliderItem(imageRes = images[currentIndex.value]){
            onClick()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 12.dp),

        ) {
            images.forEachIndexed { index, i ->
                DetailIndicator(active = index == currentIndex.value)
                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(5.dp))
                }

            }
        }

    }
}