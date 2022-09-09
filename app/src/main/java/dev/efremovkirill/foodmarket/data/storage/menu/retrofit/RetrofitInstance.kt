package dev.efremovkirill.foodmarket.data.storage.menu.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: RetrofitService by lazy {
        Retrofit.Builder()
            .baseUrl("https://randommer.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitService::class.java)
    }
}