package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.TerminalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TerminalDao:BaseDao<TerminalEntity>{
    @Query("SELECT * from terminal")
    suspend fun getAll(): List<TerminalEntity>

    @Query("SELECT * from terminal")
    fun flowAll(): Flow<List<TerminalEntity>>

}