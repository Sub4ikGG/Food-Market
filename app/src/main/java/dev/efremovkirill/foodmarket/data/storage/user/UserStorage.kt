package dev.efremovkirill.foodmarket.data.storage.user

import dev.efremovkirill.foodmarket.data.model.SUserModel

interface UserStorage {

    suspend fun signupUser(user: SUserModel)
    suspend fun getUser(phoneNumber: String): SUserModel?

}