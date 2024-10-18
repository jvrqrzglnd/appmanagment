package com.kripto.appmanager.respository

import com.kripto.appmanager.model.Client
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun insert(client: Client):Result<Unit>
    suspend fun getAll(): Result<List<Client>>
    fun flowAll(): Flow<List<Client>>
}