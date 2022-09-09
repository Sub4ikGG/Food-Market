package dev.efremovkirill.foodmarket.data.storage.menu.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {
    @Headers(
        "X-Api-Key: e1598619ecfb463d9886346d919ae527"
    )
    @GET("Text/LoremIpsum?loremType=normal&type=words")
    suspend fun getLorem(@Query("number") number: Int): Response<String>
}