package com.kripto.appmanager.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.kripto.appmanager.database.entity.ClientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao:BaseDao<ClientEntity>{
    @Query("SELECT * from client")
    suspend fun getAll(): List<ClientEntity>

    @Query("SELECT * from client")
    fun flowAll(): Flow<List<ClientEntity>>

}