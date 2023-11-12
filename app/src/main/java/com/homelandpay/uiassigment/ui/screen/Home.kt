package com.homelandpay.uiassigment.ui.screen

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.homelandpay.uiassigment.R
import com.homelandpay.uiassigment.components.GridCellItems
import com.homelandpay.uiassigment.components.ImageSlideWithIndicator
import com.homelandpay.uiassigment.components.ImageSlider
import com.homelandpay.uiassigment.components.MainAppBar
import com.homelandpay.uiassigment.components.TicketGrid
import com.homelandpay.uiassigment.navigation.Routes

@Composable
fun HomeScreen(
    navController: NavController
) {
    val imageUrls = listOf(
        R.drawable.onbo_item_2,
        R.drawable.onbo_item_3,
        R.drawable.onbo_item_4

    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        MainAppBar {

        }

        ImageSlideWithIndicator(images = imageUrls){
            navController.navigate(Routes.DETAIL_SCREEN)
        }
        GridCellItems()
        TicketGrid()
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(

                text = "Upcoming",
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                text = "View all",
                color = Color.Red,

                )


        }
        ImageSlider(images = imageUrls)
        Spacer(modifier = Modifier.height(10.dp))
    }


}