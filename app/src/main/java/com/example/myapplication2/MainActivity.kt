package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication2.ui.theme.MyApplication2Theme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment

data class Restaurant(val name: String, val tagLine: String)

val restaurants = listOf(
    Restaurant(
        name = "Pizza Pizza",
        tagLine = "Italian Pizza"
    ),
    Restaurant(
        name = "Pizza Pizza",
        tagLine = "Italian Pizza"
    ),

//    Restaurant(
//        name = "Pizza Pizza",
//        tagLine = "Italian Pizza"
//    ),
//
//    Restaurant(
//        name = "Pizza Pizza",
//        tagLine = "Italian Pizza"
//    ),
//    Restaurant(
//        name = "Pizza Pizza",
//        tagLine = "Italian Pizza"
//    ),

    )

val HorizontalRestaurantList = listOf(
    Restaurant(
        name = "Piz",
        tagLine = "Ital"
    ),
    Restaurant(
        name = "P",
        tagLine = "Ita"
    ),
    Restaurant(
        name = "Piz",
        tagLine = "Ital"
    ),
    Restaurant(
        name = "Z",
        tagLine = "Itali"
    ),
    Restaurant(
        name = "Pizz",
        tagLine = "Italin"
    ),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyApplication2Theme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
//                    RestaurantList(restaurants)
                    HorizontalRestaurantList(HorizontalRestaurantList)
                }
            }
        }
    }
}


@Composable
fun HorizontalRestaurantList(horizontalRestaurantList: List<Restaurant>) {
Row(verticalAlignment = Alignment.CenterVertically) {
    for (restaurant in horizontalRestaurantList) {
        RestaurantCard(restaurant=restaurant)
    }
}
}


@Composable
fun RestaurantList(restaurants: List<Restaurant>) {
Column(verticalArrangement = Arrangement.Bottom) {
    for (restaurant in restaurants) {
    RestaurantCard(restaurant=restaurant)
    }
}
}

@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
        color = Color.LightGray,
//        modifier = Modifier.fillMaxWidth() it is for Vertically aligned
        modifier = Modifier.height(80.dp)

    ) {
        Column {
            Text(
                restaurant.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(
                    start = 32.dp, top = 32.dp,
                    end = 32.dp, bottom = 2.dp
                )
            )
            Text(
                restaurant.tagLine,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    start = 32.dp, top = 2.dp,
                    end = 32.dp, bottom = 32.dp
                )
            )
        }
    }


}



@Preview(showBackground = true, name = "cardPerview", backgroundColor = 0xFF4CAF50)
@Composable
fun RestaurantCardPreview() {
    MyApplication2Theme {
       RestaurantCard(
           Restaurant(
               name = "Pizza Pizza",
               tagLine = "Italian Pizza Demo"
           )
       )
    }
}
@Preview(showBackground = true, name = "listPerview", backgroundColor = 0xFFFF5722,
    showSystemUi = true
)
@Composable
fun RestaurantListPerview() {
    MyApplication2Theme {
        RestaurantList(restaurants)
    }
}




