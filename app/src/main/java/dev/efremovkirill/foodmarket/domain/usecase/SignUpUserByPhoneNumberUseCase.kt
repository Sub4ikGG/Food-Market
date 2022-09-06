package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.repository.UserRepository

class SignUpUserByPhoneNumberUseCase {

    lateinit var repository: UserRepository

    suspend fun execute(user: UserModel): Boolean {
        return repository.signupUser(user)
    }
}