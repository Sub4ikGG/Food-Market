package dev.efremovkirill.foodmarket.domain.repository

import dev.efremovkirill.foodmarket.domain.model.UserModel

interface UserRepository {

    suspend fun loginUser(user: UserModel): Boolean

    suspend fun signupUser(user: UserModel): Boolean

    suspend fun getUser(): UserModel
}