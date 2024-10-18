package com.kripto.appmanager.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kripto.appmanager.database.dao.AppwareDao
import com.kripto.appmanager.database.dao.AppwareTerminalDao
import com.kripto.appmanager.database.dao.ClientDao
import com.kripto.appmanager.database.dao.StoreDao
import com.kripto.appmanager.database.dao.TerminalDao
import com.kripto.appmanager.database.dao.TerminalStoreDao
import com.kripto.appmanager.database.entity.AppwareEntity
import com.kripto.appmanager.database.entity.AppwareTerminalEntity
import com.kripto.appmanager.database.entity.ClientEntity
import com.kripto.appmanager.database.entity.StoreEntity
import com.kripto.appmanager.database.entity.TerminalEntity
import com.kripto.appmanager.database.entity.TerminalStoreEntity

@Database(
    version = 1,
    entities = [
        ClientEntity::class,
        StoreEntity::class,
        TerminalEntity::class,
        AppwareEntity::class,
        AppwareTerminalEntity::class,
        TerminalStoreEntity::class
    ]
)
abstract class MainDatabase: RoomDatabase() {
    abstract fun clientDao():ClientDao
    abstract fun storeDao():StoreDao
    abstract fun terminalDao():TerminalDao
    abstract fun appwareDao():AppwareDao
    abstract fun appwareTerminalDao():AppwareTerminalDao
    abstract fun terminalStoreDao():TerminalStoreDao


}