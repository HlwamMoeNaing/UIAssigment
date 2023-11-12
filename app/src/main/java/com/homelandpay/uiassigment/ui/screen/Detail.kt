package com.homelandpay.uiassigment.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.homelandpay.uiassigment.R
import com.homelandpay.uiassigment.components.BoarderIcon
import com.homelandpay.uiassigment.components.DetailImageSlideWithIndicator
import com.homelandpay.uiassigment.components.DetailImageSliderItem
import com.homelandpay.uiassigment.components.ImageSlideWithIndicator
import com.homelandpay.uiassigment.components.MainAppBar

@Composable
fun DetailScreen(
    navController: NavController
) {
    val imageUrls = listOf(
        R.drawable.onbo_item_2,
        R.drawable.onbo_item_3,
        R.drawable.onbo_item_4

    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        DetailImageSlideWithIndicator(images = imageUrls){
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Zone 1",
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,

        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Algator Gar",
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        BoarderIcon(
            modifier = Modifier.padding(horizontal = 16.dp),
        )

        Spacer(modifier = Modifier.height(20.dp))
        val textString = R.string.detail_text
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(id =textString ),



        )
    }
}