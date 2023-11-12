package com.homelandpay.uiassigment.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.homelandpay.uiassigment.R
import com.homelandpay.uiassigment.items.GridItem
import com.homelandpay.uiassigment.items.TicketItem
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainAppBar(
    onClick:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Image(
                painterResource(id = R.drawable.back_arrow_24),
                contentDescription = "",
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
            )
            Image(
                painterResource(id = R.drawable.app_bar_center_icon),
                contentDescription = "",
                modifier = Modifier
                    .weight(1f)
                    .size(40.dp)
                    .clickable {
                        onClick()
                    }
            )

         Box {
             Image(
                 painter = painterResource(id = R.drawable.app_bar_leading_icon) ,
                 contentDescription = "Back",
                 modifier = Modifier
                     .align(Alignment.CenterEnd)

                     .size(24.dp),

                 )
         }
        }
    }
}

@Composable
fun ImageSlider(
    images: List<Int> // List of image URLs
) {
    val padding = 16.dp
    LazyRow(
        contentPadding = PaddingValues(horizontal = padding),
        horizontalArrangement = Arrangement.spacedBy(padding),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(images) { imageUrl ->
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Box (
                    modifier = Modifier.fillMaxWidth()
                ){
                    val painter = rememberImagePainter(data = imageUrl)
                    Image(
                        modifier =Modifier.fillMaxWidth(),
                        painter = painter,
                        contentDescription = "Image Slider",
                        contentScale = ContentScale.FillWidth
                    )

                    Text(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        text = "Dive Feeding @ Shipwreck",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.align(Alignment.TopStart).padding(start = 8.dp, top = 8.dp),
                        text = "2:30",
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,

                    )
                }

            }
        }
    }
}

@Composable
fun ImageSliderItem(imageRes: Int,onClick: () -> Unit) {
    Image(
        painter = painterResource(id = imageRes), contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                onClick()
            }
    )
}

@Composable
fun Indicator(active: Boolean) {
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
fun ImageSlideWithIndicator(images: List<Int>,onClick:()->Unit) {
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
        ImageSliderItem(imageRes = images[currentIndex.value]){
            onClick()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            images.forEachIndexed { index, i ->
                Indicator(active = index == currentIndex.value)
                if (index < images.size - 1) {
                    Spacer(modifier = Modifier.width(5.dp))
                }

            }
        }

    }
}


@Composable
fun GridItem(iconId: Int, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = text,
            modifier = Modifier
                .size(48.dp)
                .background(Color.LightGray, shape = CircleShape)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun MyActivityContent() {
    // Replace with your actual image URLs
    val imageUrls = listOf(
        R.drawable.onbo_item_2,
        R.drawable.onbo_item_3,
        R.drawable.onbo_item_3

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ImageSlider(images = imageUrls)
        // ... Other content
    }
}


@Composable
fun GridItemStyle(gridItem: GridItem) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = gridItem.icon),
            contentDescription = gridItem.title,
            modifier = Modifier
                .size(48.dp)
                .background(Color.LightGray, shape = CircleShape)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = gridItem.title,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun GridCellItems() {
    val gridList = listOf(
        GridItem(
            "map",
            R.drawable.map,
        ),
        GridItem(
            "Inhabitants",
            R.drawable.fish,
        ),
        GridItem(
            "Arrow",
            R.drawable.a_text,
        ),
        GridItem(
            "Shopping",
            R.drawable.shopping,
        ),
        GridItem(
            "dine",
            R.drawable.dine,
        ),
        GridItem(
            "Meet & Greet",
            R.drawable.meet_greet,
        )
    )


    LazyVerticalGrid(
        columns = GridCells.Fixed(4), contentPadding = PaddingValues(8.dp),
        modifier = Modifier.padding(8.dp).height(200.dp)
    ) {
        items(gridList) {
            GridItemStyle(gridItem = it)
        }
    }
}



@Composable
fun GridCellItem(
    ticketItem: TicketItem
) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = ticketItem.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = ticketItem.iconId),
                    contentDescription = ticketItem.title,
                    modifier = Modifier.size(24.dp)
                )

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = ticketItem.subtitle,
                maxLines = 1,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Surface(
                modifier = Modifier
                    .align(Alignment.End)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = ticketItem.buttonText,
                    color = Color.Black,
                    fontSize = 12.sp
                )
            }
        }
    }
}
// Example usage
@Composable
fun TicketGrid() {
//todo change with horizontal list
    val ticketList = listOf(
        TicketItem(
            title = "My e-tickets",
            subtitle = "There aren't any yet.",
            buttonText = "Retrieve here",
            iconId = R.drawable.ticket_icon // Replace with your icon resource
        ) ,
        TicketItem(
            title = "Park hours",
            subtitle = "Today, 13 Feb 10am - 5pm",
            buttonText = "Plan my visit",
            iconId = R.drawable.clock_icon // Replace with your icon resource
        )
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp),
        modifier = Modifier.padding(8.dp).height(150.dp)
    ) {
        items(ticketList) {
            GridCellItem(it)
        }
    }
}


@Composable
fun BoarderIcon(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                BorderStroke(
                    1.dp,
                    Color.Gray
                ),
                RoundedCornerShape(4.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Row(
            modifier = modifier.padding(horizontal = 8.dp, vertical = 5.dp)
        ) {
            Image(
                painterResource(id = R.drawable.runnung_man_icon),
                contentDescription = "",
                modifier = Modifier.size(24.dp)

            )
            Text(
                text = "410m away",
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "Map",
                color = Color.Red
            )
        }
    }
}

@Preview
@Composable
fun PreviewMain() {
    MyActivityContent()
}
