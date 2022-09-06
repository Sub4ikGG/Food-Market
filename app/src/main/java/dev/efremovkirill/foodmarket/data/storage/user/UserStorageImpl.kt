package dev.efremovkirill.foodmarket.data.storage.user

import dev.efremovkirill.foodmarket.data.model.SUserModel

class UserStorageImpl: UserStorage {

    override suspend fun signupUser(user: SUserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun loginUser(user: SUserModel): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): SUserModel {
        TODO("Not yet implemented")
    }

}