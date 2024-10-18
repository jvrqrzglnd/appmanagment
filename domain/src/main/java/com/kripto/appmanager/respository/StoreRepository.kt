package com.kripto.appmanager.respository

import com.kripto.appmanager.model.Store
import kotlinx.coroutines.flow.Flow

interface StoreRepository {
    suspend fun insert(client: Store):Result<Unit>
    suspend fun getAll(): Result<List<Store>>
    fun flowAll(): Flow<List<Store>>
}