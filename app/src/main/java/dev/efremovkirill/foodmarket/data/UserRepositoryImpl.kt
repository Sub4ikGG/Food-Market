package dev.efremovkirill.foodmarket.data

import dev.efremovkirill.foodmarket.data.model.SUserModel
import dev.efremovkirill.foodmarket.data.storage.user.UserStorage
import dev.efremovkirill.foodmarket.domain.model.UserModel
import dev.efremovkirill.foodmarket.domain.repository.UserRepository

class UserRepositoryImpl(val userStorage: UserStorage): UserRepository {
    override suspend fun loginUser(phoneNumber: String, password: String): Boolean {
        val userByPhoneNumber = getUserByNumber(phoneNumber)
        println(userByPhoneNumber)
        println(phoneNumber + " " + password)
        return userByPhoneNumber.password == password
    }

    override suspend fun signupUser(user: UserModel): Boolean {
        val userByPhoneNumber = getUserByNumber(user.phoneNumber)

        if(userByPhoneNumber.name == "") {
            val sUser = SUserModel(0, user.name, user.phoneNumber, user.email, user.password)
            userStorage.signupUser(sUser)
            return true
        }

        return false
    }

    override suspend fun getUserByNumber(phoneNumber: String): UserModel {
        val sUser = userStorage.getUser(phoneNumber)

        return if(sUser != null)
            UserModel(sUser.name, phoneNumber, sUser.email, sUser.password)
        else
            UserModel("", "", "", "")
    }
}