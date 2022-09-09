package dev.efremovkirill.foodmarket.data.di

import dagger.Module
import dagger.Provides
import dev.efremovkirill.foodmarket.data.MenuRepositoryImpl
import dev.efremovkirill.foodmarket.data.OrdersRepositoryImpl
import dev.efremovkirill.foodmarket.data.UserRepositoryImpl
import dev.efremovkirill.foodmarket.data.storage.menu.MenuStorage
import dev.efremovkirill.foodmarket.data.storage.menu.MenuStorageImpl
import dev.efremovkirill.foodmarket.data.storage.orders.OrdersStorage
import dev.efremovkirill.foodmarket.data.storage.orders.OrdersStorageImpl
import dev.efremovkirill.foodmarket.data.storage.room.repository.OrdersRoomRepository
import dev.efremovkirill.foodmarket.data.storage.room.repository.UserRoomRepository
import dev.efremovkirill.foodmarket.data.storage.user.UserStorage
import dev.efremovkirill.foodmarket.data.storage.user.UserStorageImpl
import dev.efremovkirill.foodmarket.domain.repository.MenuRepository
import dev.efremovkirill.foodmarket.domain.repository.OrdersRepository
import dev.efremovkirill.foodmarket.domain.repository.UserRepository

@Module
class RepositoryModule {

    @Provides
    fun provideMenuStorage(): MenuStorage {
        return MenuStorageImpl()
    }

    @Provides
    fun provideUserStorage(userRoomRepository: UserRoomRepository): UserStorage {
        return UserStorageImpl(userRoomRepository)
    }

    @Provides
    fun provideOrdersStorage(ordersRoomRepository: OrdersRoomRepository): OrdersStorage {
        return OrdersStorageImpl(ordersRoomRepository)
    }

    @Provides
    fun provideMenuRepository(menuStorage: MenuStorage): MenuRepository {
        return MenuRepositoryImpl(menuStorage)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage)
    }

    @Provides
    fun provideOrdersRepository(ordersStorage: OrdersStorage): OrdersRepository {
        return OrdersRepositoryImpl(ordersStorage)
    }
}