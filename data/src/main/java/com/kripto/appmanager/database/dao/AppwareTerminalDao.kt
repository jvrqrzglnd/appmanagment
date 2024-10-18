package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.AppwareTerminalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppwareTerminalDao:BaseDao<AppwareTerminalEntity>{
    @Query("SELECT * from appware_terminal")
    suspend fun getAll(): List<AppwareTerminalEntity>

    @Query("SELECT * from appware_terminal")
    fun flowAll(): Flow<List<AppwareTerminalEntity>>

}