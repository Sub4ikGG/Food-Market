package dev.efremovkirill.foodmarket.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class SUserModel(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "phone_number") var phoneNumber: String,
    @ColumnInfo(name = "email") var email: String,
    @ColumnInfo(name = "password") var password: String
)
