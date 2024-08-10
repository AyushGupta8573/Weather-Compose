package com.example.weather_compose.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//private const val CITY = "lucknow"
//private const val API_KEY = "a7cd198c020bb86e19ee90789e199908"
private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface WeatherApiService{
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") appKey: String,
    ): WeatherResponse
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}
