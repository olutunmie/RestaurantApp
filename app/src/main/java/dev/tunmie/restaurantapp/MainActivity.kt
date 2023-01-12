package dev.tunmie.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tunmie.restaurantapp.ui.theme.RestaurantAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			RestaurantAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					RestaurantsScreen()
				}
			}
		}
	}
}


@Composable
fun RestaurantsScreen() {
	RestaurantItem()
}

@Composable
fun RestaurantItem() {
	Card(
		elevation = 4.dp,
		modifier = Modifier.padding(8.dp)
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier.padding(8.dp)
		) {
			RestaurantIcon(
				Icons.Filled.Place,
				Modifier.weight(0.15f)
			)
			RestaurantDetails(Modifier.weight(0.85f))
		}
	}
}

@Composable
private fun RestaurantIcon(icon: ImageVector, modifier: Modifier) {
	Image(
		imageVector = icon,
		contentDescription = "Restaurant Icon",
		modifier = modifier.padding(8.dp)
	)
}

@Composable
private fun RestaurantDetails(modifier: Modifier) {
	Column(modifier = modifier) {
		Text(text = "Alfredo's dishes", style = MaterialTheme.typography.h6)
		CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
			Text(text = "At Alfredo's .. seafood dishes", style = MaterialTheme.typography.body2)
		}
	}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
	RestaurantAppTheme {
		RestaurantsScreen()
	}
}