package com.kripto.appmanager.respository

import com.kripto.appmanager.model.Appware
import kotlinx.coroutines.flow.Flow

interface AppwareRepository {
    suspend fun insert(client: Appware):Result<Unit>
    suspend fun getAll(): Result<List<Appware>>
    fun flowAll(): Flow<List<Appware>>
}