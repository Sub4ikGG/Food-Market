package dev.efremovkirill.foodmarket.data.storage.menu.retrofit

import retrofit2.Response

class LoremRepository {
    suspend fun getLorem(number: Int): Response<String> {
        return RetrofitInstance.api.getLorem(number)
    }
}