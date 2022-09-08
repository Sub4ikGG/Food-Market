package dev.efremovkirill.foodmarket.domain.usecase

import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.repository.UserRepository
import javax.inject.Inject

class LogInUserByPhoneNumberUseCase {

    @Inject
    lateinit var repository: UserRepository

    suspend fun execute(phoneNumber: String, password: String): Boolean {
        return repository.loginUser(phoneNumber, password)
    }
}