package dev.efremovkirill.foodmarket.data.storage.user

import dev.efremovkirill.foodmarket.data.model.SUserModel
import dev.efremovkirill.foodmarket.data.storage.room.repository.UserRoomRepository
import javax.inject.Inject

class UserStorageImpl @Inject constructor(var userRoomRepository: UserRoomRepository): UserStorage {

    override suspend fun signupUser(user: SUserModel) {
        userRoomRepository.putUser(user)
    }

    override suspend fun getUser(phoneNumber: String): SUserModel? {
        return userRoomRepository.getUserByNumber(phoneNumber)
    }

}