package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.StoreEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao:BaseDao<StoreEntity>{
    @Query("SELECT * from store")
    suspend fun getAll(): List<StoreEntity>

    @Query("SELECT * from store")
    fun flowAll(): Flow<List<StoreEntity>>

}