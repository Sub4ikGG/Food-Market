package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.storage.user.UserStorage
import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.repository.UserRepository

class UserRepositoryImpl(userStorage: UserStorage): UserRepository {
    override suspend fun loginUser(user: UserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun signupUser(user: UserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): UserModel {
        TODO("Not yet implemented")
    }
}