package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.repository.UserRepository

class GetUserUseCase {

    lateinit var repository: UserRepository

    suspend fun execute(): UserModel {
        return repository.getUser()
    }
}