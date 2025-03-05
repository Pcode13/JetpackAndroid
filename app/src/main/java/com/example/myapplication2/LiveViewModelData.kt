package com.example.myapplication2

import android.os.Bundle
import androidx.compose.foundation.Image

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myapplication2.ui.theme.MyApplication2Theme

data class Restaurant(
    val name: String,
    val address: String,
    val phone: String,
    val rating: Float,
    val image: Int,
    val cuisine: String,
    val menuItems: List<MenuItem>
)

data class MenuItem(
    val name: String,
    val price: Float
)

class RestaurantViewModel : ViewModel() {
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    init {
        _restaurant.value = Restaurant(
            name = "Loony Cafe",
            address = "1234 Main St, Seattle, USA",
            phone = "555-1234-345",
            rating = 4.5f,
            image = R.drawable.res_img1,
            cuisine = "Italian",
            menuItems = listOf(
                MenuItem(name = "Spaghetti", price = 12.99f),
                MenuItem(name = "Lasagna", price = 14.99f),
                MenuItem(name = "Pizza", price = 9.99f)
            )
        )
    }

    fun updateRestaurantRating(rating: Float) {
        _restaurant.value = _restaurant.value?.copy(rating = rating)
    }
}


class LiveViewModelData : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Eatelicious",
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
    ) {
            contentPadding -> RestaurantProfile(contentPadding, RestaurantViewModel())
    }
}

@Composable
fun RestaurantProfile(contentPadding: PaddingValues, viewModel: RestaurantViewModel) {
    val restaurantState: State<Restaurant?> = viewModel.restaurant.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                restaurantState.value?.let { restaurant ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Image(
                            painter = painterResource(
                                restaurant.image
                            ),
                            contentDescription = "restaurant",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clip(RoundedCornerShape(10.dp))
                                .size(350.dp),
                            contentScale = ContentScale.Crop
                        )

                    }

                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = restaurant.name ?: "",
                                style = MaterialTheme.typography.headlineLarge
                            )
                            Text(text = restaurant.address ?: "")
                            Text(text = restaurant.phone ?: "")
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Rating: ${restaurant.rating}",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Cuisine: ${restaurant.cuisine}")

                    restaurant.menuItems.forEach { menuItem ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = menuItem.name,
                                style = MaterialTheme.typography.bodySmall
                            )
                            Text(
                                text = "${menuItem.price}",
                                style = MaterialTheme.typography.bodySmall
                            )
                        }
                    }

                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                restaurantState.value?.let { restaurant ->
                    RestaurantRatingBar(
                        rating = restaurant.rating,
                        onRatingChanged = { viewModel.updateRestaurantRating(it) }
                    )
                }
            }
        }
    }

}


@Composable
fun RestaurantRatingBar(rating: Float, onRatingChanged: (Float) -> Unit) {
    val currentRating = remember { mutableStateOf(rating) }

    Row {
        RatingBar(
            rating = currentRating,
            onRatingChanged = {
                currentRating.value = it
                onRatingChanged(it)
            }
        )
    }
}

@Composable
fun RatingBar(rating: MutableState<Float>, onRatingChanged: (Float) -> Unit) {
    val maxRating = 5f

    Column {
        Row {
            repeat(maxRating.toInt()) { index ->
                val currentRating = index + 1f
                val isSelected = currentRating <= rating.value
                Icon(
                    imageVector = if (isSelected) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = null,
                    tint = if (isSelected) Color.Yellow else Color.Gray,
                    modifier = Modifier
                        .clickable { onRatingChanged(currentRating) }
                        .padding(4.dp)
                )
            }
        }
        Text(
            text = rating.value.toString(),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

//@Preview(showBackground = true,
//    name = "appPreview",
//    showSystemUi = true
//)
//@Composable
//fun PreviewRestaurantApp() {
//    MyApplication2Theme {
//        RestaurantApp()
//    }
//}
