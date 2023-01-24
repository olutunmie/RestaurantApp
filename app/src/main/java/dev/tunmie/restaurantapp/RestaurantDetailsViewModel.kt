package dev.tunmie.restaurantapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantDetailsViewModel(): ViewModel() {
	private var restInterface: RestaurantsApiService
	init {
		val retrofit: Retrofit = Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl("https://resutoran-a2-default-rtdb.firebaseio.com/")
			.build()
		restInterface = retrofit.create(
			RestaurantsApiService::class.java
		)
	}

	private suspend fun getRemoteRestaurant(id: Int) : Restaurant {
		return withContext(Dispatchers.IO) {
			val responseMap = restInterface
				.getRestaurant(id)
			return@withContext responseMap.values.first()
		}
	}
}