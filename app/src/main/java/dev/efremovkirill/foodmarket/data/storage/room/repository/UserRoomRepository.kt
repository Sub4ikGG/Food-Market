package dev.efremovkirill.foodmarket.data.storage.room.repository

import dev.efremovkirill.foodmarket.data.model.SUserModel
import dev.efremovkirill.foodmarket.data.storage.room.dao.UserDao

class UserRoomRepository(val userDao: UserDao) {

    suspend fun putUser(user: SUserModel) {
        userDao.putUser(user)
    }

    suspend fun getUserByNumber(phoneNumber: String): SUserModel? {
        return userDao.getUserByPhoneNumber(phoneNumber)
    }
}