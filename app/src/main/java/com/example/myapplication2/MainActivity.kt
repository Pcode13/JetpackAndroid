package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign

data class Restaurant(
    val name: String,
    val tagLine: String,
    val imageUrl: Int,
)

val restaurants = listOf(
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img1
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img2
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img3
        ),

        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img4
        ),

        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img5
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img6
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img7
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img8
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img9
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img10
        ),
        Restaurant(
            name = "Pizza Pizza",
            tagLine = "Italian Pizza",
            imageUrl = R.drawable.res_img11
        ),

        )



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MyApplication2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RestaurantApp()
//                    RestaurantList(restaurants)
//                    HorizontalRestaurantList(HorizontalRestaurantList)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {

    val restaurantsNewList = remember {
        mutableStateListOf(
            Restaurant(
                "Belgian Waffles",
                "The best in town!", R.drawable.res_img1
            ),
            Restaurant(
                "Stomachful",
                "Never leave hungry", R.drawable.res_img2
            ),
            Restaurant(
                "Big Belly Noodles",
                "Delicious noodles", R.drawable.res_img3
            ),
            Restaurant(
                "Cakery",
                "Cakes for every occasion", R.drawable.res_img4
            ),
            Restaurant(
                "Pan Asia",
                "The best Asian food", R.drawable.res_img5
            ),
            Restaurant(
                "House of Pancakes",
                "Best for breakfast", R.drawable.res_img6
            ),
            Restaurant(
                "Sizzling Steakhouse",
                "Come for the sizzle", R.drawable.res_img7
            ),
            Restaurant(
                "Something fishy",
                "Everything from the sea", R.drawable.res_img8
            ),
            Restaurant(
                "Pasta Ya Gotcha",
                "Pastas and more", R.drawable.res_img9
            ),
            Restaurant(
                "Healthy and Yummy",
                "Can't believe it's healthy!", R.drawable.res_img10
            ),
        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Restaurant App",
                    color = MaterialTheme.colorScheme.primary,
                    ) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                )
            )
        },
//        floatingActionButton = {
//            FloatingActionButton(onClick = { restaurantsNewList.add(restaurantsNewList.random()) }) {
//                Icon(Icons.Filled.Add, contentDescription = null)
//            }
//        }

        ) { contentPadding -> SliderMenuList(contentPadding, restaurantsNewList)
//        DropdownMenuList(contentPadding,restaurantsNewList)


//        CounterApp(contentPadding)
//        TextInputApp(contentPadding)
//        RestaurantProfile(contentPadding)
//        RestaurantList(contentPadding, restaurantsNewList)
    }

}

@Composable
fun SliderMenuList(
    contentPadding: PaddingValues,
    restaurantsNewList:List<Restaurant>,
) {
    val sliderValue = remember { mutableStateOf(0f) }
    Card(
        modifier = Modifier
            .padding(contentPadding)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            MaterialTheme.colorScheme.background
        )

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),

        ){
            Box(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()

            ){
                Image(
                    painter = painterResource(
                        restaurantsNewList[sliderValue.value.toInt()].imageUrl
                    ),
                    contentDescription = "restaurant",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(350.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Box(
                modifier = Modifier
                    .padding(32.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ){
                Text(
                    restaurantsNewList[sliderValue.value.toInt()].name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp, bottom = 16.dp))

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
            ){
                Slider(
                    value = sliderValue.value,
                    onValueChange = { newValue ->
                        sliderValue.value = newValue
                    },
                    valueRange = 0f..10f,
                    steps = 10
                )
            }

        }

    }
}

//@Composable
//fun DropdownMenuList(
//    contentPadding: PaddingValues,
//    restaurantsNewList: List<Restaurant>
//) {
//    var selectedIndex by remember { mutableStateOf(0) }
//    var expanded by remember { mutableStateOf(false) }
//
//    Card(
//        modifier = Modifier
//            .padding(contentPadding)
//            .fillMaxWidth(),
//        shape = RectangleShape,
//        colors = CardDefaults.cardColors(
//            MaterialTheme.colorScheme.background
//        )
//    ) {
//        Column(modifier = Modifier.fillMaxWidth()) {
//            Box(
//                modifier = Modifier
//                    .padding(32.dp)
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//
//                Image(
//                    painter = painterResource(restaurantsNewList[selectedIndex].imageUrl),
//                    contentDescription = "restaurant",
//                    modifier = Modifier
//                        .align(Alignment.Center)
//                        .size(350.dp)
//                        .clip(RectangleShape),
//                    contentScale = ContentScale.Crop
//                )
//            }
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.BottomCenter)
//            ) {
//                Text(
//                    restaurantsNewList[selectedIndex].name,
//                    textAlign = TextAlign.Center,
//                    style = MaterialTheme.typography.titleLarge,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable(onClick = { expanded = true })
//                        .padding(top = 4.dp, bottom = 16.dp)
//
//                )
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false },
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    restaurantsNewList.forEachIndexed { index, restaurant ->
//                        DropdownMenuItem(
//
//                            onClick = {
//                                selectedIndex = index
//                                expanded = false
//                            },
//                            text = {
//                                Card(
//                                    modifier = Modifier
//                                        .padding(4.dp)
//                                        .fillMaxWidth(),
//                                    colors = CardDefaults.cardColors(
//                                        MaterialTheme.colorScheme.background
//                                    )
//                                ) {
//                                    Text(text = restaurant.name)
//                                }
//                            }
//
//                        )
//                    }
//                }
//            }
//        }
//    }
//}


//@Composable
//fun CounterApp(contentPadding: PaddingValues) {
//    Card(
//        modifier = Modifier
//            .padding(contentPadding)
//            .fillMaxWidth(),
//        shape = RectangleShape,
//        colors = CardDefaults.cardColors(
//            MaterialTheme.colorScheme.background
//    ) ){
//        var counter = rememberSaveable { mutableStateOf(0) }
//        Box(modifier = Modifier.fillMaxSize()){
//            Column(modifier = Modifier.wrapContentSize().align(Alignment.Center)) {
//                Box(modifier = Modifier.fillMaxWidth().wrapContentHeight()) {
//                    Text(
//                        text = counter.value.toString(),
//                        style = MaterialTheme.typography.titleLarge,
//                        modifier = Modifier.align(Alignment.Center)
//                    )
//            }
//                Button(
//                    onClick = { counter.value = 0 },
//                    modifier = Modifier.padding(8.dp)
//
//
//                ) {
//                    Text("Reset")
//                }
//                Spacer(modifier = Modifier.weight(1f))
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Button(
//                        onClick = { counter.value-- },
//                        modifier = Modifier
//                            .weight(1f) // The button will take up half of the available width
//                            .fillMaxWidth()
//                    ) {
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Icon(
//                                imageVector = Icons.Filled.KeyboardArrowDown, // Use your desired icon
//                                contentDescription = "Favorite Icon",
//                                modifier = Modifier.padding(end = 8.dp) // Add some padding between the icon and the text
//                            )
//                            Text("Decrement")
//                        }
//                    }
//                    Button(
//                        onClick = { counter.value++ },
//                        modifier = Modifier
//                            .weight(1f) // The button will take up half of the available width
//                            .fillMaxWidth()
//                    ) {
//                        Row(verticalAlignment = Alignment.CenterVertically) {
//                            Icon(
//                                imageVector = Icons.Filled.KeyboardArrowUp, // Use your desired icon
//                                contentDescription = "Favorite Icon",
//                                modifier = Modifier.padding(end = 8.dp) // Add some padding between the icon and the text
//                            )
//                            Text("Increment")
//                        }
//                    }
//
//
//
//
//
//
//                }
//            }
//        }
//
//    }
//}
//
//@Composable
//fun TextInputApp(contentPadding: PaddingValues) {
//    Card(
//        modifier = Modifier
//            .padding(contentPadding)
//            .fillMaxWidth(),
//        shape = RectangleShape,
//        colors = CardDefaults.cardColors(
//            MaterialTheme.colorScheme.background
//        )
//    ) {
//        Box(modifier = Modifier.fillMaxSize()) {
//            Column(
//                modifier = Modifier.padding(16.dp).align(Alignment.Center)
//            ) {
//                var name by remember { mutableStateOf("") }
//                var tagLine by remember { mutableStateOf("") }
//                Box(modifier = Modifier.fillMaxWidth()) {
//                    if (name.isNotEmpty()) {
//                        Text(
//                            text = name,
//                            modifier = Modifier
//                                .padding(bottom = 8.dp)
//                                .align(Alignment.Center),
//                            style = MaterialTheme.typography.titleLarge,
//                        )
//                    }
//                }
//                OutlinedTextField(
//                    value =name,
//                    onValueChange = { name = it },
//                    label = { Text("Update restaurant name") },
//                    modifier = Modifier.fillMaxWidth()
//                )
//            }
//        }
//    }
//}


//@Composable
//fun HorizontalRestaurantList(horizontalRestaurantList: List<Restaurant>) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        for (restaurant in horizontalRestaurantList) {
//            RestaurantCard(restaurant = restaurant)
//        }
//    }
//}


//@Composable
//fun RestaurantList( contentPadding: PaddingValues,restaurants: List<Restaurant>) {
//    Column(modifier = Modifier.padding(contentPadding)
//        .verticalScroll(rememberScrollState()),
//    ) {
//       restaurants.forEach {
//           restaurant -> RestaurantCard(restaurant = restaurant)
//       }
//    }
//}
//
//@Composable
//fun RestaurantCard(restaurant: Restaurant) {
//    Card (
//        modifier = Modifier.fillMaxWidth(),
//                shape = CutCornerShape(10.dp),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 10.dp
//        ),
//        colors = CardDefaults.cardColors(
//            Color.White
//        )
//    )
//{
//
//
//        Row(Modifier.padding(8.dp)) {
//            Image(
//                painter = painterResource(id = restaurant.imageUrl),
//                contentDescription = "Restaurant Image",
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(CircleShape)
//                    .border(
//                        width = 2.dp,
//                        color = Color.Green,
//                        shape = CircleShape
//                    ),
//                contentScale = ContentScale.Crop
//
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//
//            Column(verticalArrangement = Arrangement.Center) {
//                Text(
//                    restaurant.name,
//                    style = MaterialTheme.typography.titleLarge,
//                    modifier = Modifier.padding(
//                        start = 16.dp,
//                        end = 16.dp,
//                    )
//                )
//
//                Spacer(Modifier.height(4.dp))
//                Text(
//                    restaurant.tagLine,
//                    style = MaterialTheme.typography.labelSmall,
//                    modifier = Modifier.padding(
//                        start = 16.dp,
//                        end = 16.dp,
//                    )
//                )
//            }
//        }
//    }
//
//}


//@Preview(showBackground = true, name = "cardPerview", backgroundColor = 0xFF4CAF50)
//@Composable
//fun RestaurantCardPreview() {
//    MyApplication2Theme {
//        RestaurantCard(
//            Restaurant(
//                name = "Pizza Pizza",
//                tagLine = "Italian Pizza Demo",
//                imageUrl = R.drawable.res_img1
//            )
//        )
//    }
//}

//@Preview(
//    showBackground = true, name = "listPerview", backgroundColor = 0xFFFF5722,
//    showSystemUi = true
//)
//@Composable
//fun RestaurantListPerview() {
//    MyApplication2Theme {
//       RestaurantApp()
//    }
//}



    @Preview(showBackground = true, name = "appPreview", showSystemUi = true)
    @Composable
    fun PreviewRestaurantApp() {
        MyApplication2Theme {
            RestaurantApp()
        }
    }
