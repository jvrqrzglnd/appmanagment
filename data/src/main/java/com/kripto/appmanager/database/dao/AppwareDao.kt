package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.AppwareEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppwareDao:BaseDao<AppwareEntity>{
    @Query("SELECT * from appware")
    suspend fun getAll(): List<AppwareEntity>

    @Query("SELECT * from appware")
    fun flowAll(): Flow<List<AppwareEntity>>

}