package dev.efremovkirill.foodmarket.data.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.efremovkirill.foodmarket.data.model.SFoodModel
import dev.efremovkirill.foodmarket.data.model.SOrderModel
import dev.efremovkirill.foodmarket.data.model.SUserModel
import dev.efremovkirill.foodmarket.data.storage.room.dao.OrdersDao
import dev.efremovkirill.foodmarket.data.storage.room.dao.UserDao
import dev.efremovkirill.foodmarket.typeconverter.SCategoryTypeConverter
import dev.efremovkirill.foodmarket.typeconverter.SFoodListTypeConverter

@Database(entities = [SUserModel::class, SOrderModel::class, SFoodModel::class], version = 1, exportSchema = false)
@TypeConverters(SFoodListTypeConverter::class, SCategoryTypeConverter::class)
abstract class FoodMarketDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun ordersDao(): OrdersDao

    companion object {
        @Volatile
        private var INSTANCE: FoodMarketDatabase? = null

        fun getDatabase(context: Context): FoodMarketDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FoodMarketDatabase::class.java,
                    "foodmarket_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}