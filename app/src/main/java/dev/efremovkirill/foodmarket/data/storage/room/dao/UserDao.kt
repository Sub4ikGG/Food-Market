package dev.efremovkirill.foodmarket.data.storage.room.dao

import androidx.room.*
import dev.efremovkirill.foodmarket.data.model.SUserModel

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun putUser(user: SUserModel)

    @Query("SELECT * FROM users_table WHERE phone_number = :phoneNumber")
    suspend fun getUserByPhoneNumber(phoneNumber: String): SUserModel?

}