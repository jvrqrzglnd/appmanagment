package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.TerminalStoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TerminalStoreDao:BaseDao<TerminalStoreEntity>{
    @Query("SELECT * from terminal_store")
    suspend fun getAll(): List<TerminalStoreEntity>

    @Query("SELECT * from terminal_store")
    fun flowAll(): Flow<List<TerminalStoreEntity>>

}