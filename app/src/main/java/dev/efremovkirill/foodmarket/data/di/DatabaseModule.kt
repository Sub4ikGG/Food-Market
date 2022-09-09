package dev.efremovkirill.foodmarket.data.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.efremovkirill.foodmarket.data.storage.room.FoodMarketDatabase
import dev.efremovkirill.foodmarket.data.storage.room.dao.OrdersDao
import dev.efremovkirill.foodmarket.data.storage.room.dao.UserDao
import dev.efremovkirill.foodmarket.data.storage.room.repository.OrdersRoomRepository
import dev.efremovkirill.foodmarket.data.storage.room.repository.UserRoomRepository

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): FoodMarketDatabase {
        return FoodMarketDatabase.getDatabase(context)
    }

    @Provides
    fun provideOrdersDao(database: FoodMarketDatabase): OrdersDao {
        return database.ordersDao()
    }

    @Provides
    fun provideUserDao(database: FoodMarketDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideUserRepository(dao: UserDao): UserRoomRepository {
        return UserRoomRepository(dao)
    }

    @Provides
    fun provideOrdersRepository(dao: OrdersDao): OrdersRoomRepository {
        return OrdersRoomRepository(dao)
    }
}