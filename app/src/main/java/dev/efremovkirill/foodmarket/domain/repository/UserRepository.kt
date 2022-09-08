package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.domain.model.UserModel

interface UserRepository {

    suspend fun loginUser(phoneNumber: String, password: String): Boolean

    suspend fun signupUser(user: UserModel): Boolean

    suspend fun getUserByNumber(phoneNumber: String): UserModel
}