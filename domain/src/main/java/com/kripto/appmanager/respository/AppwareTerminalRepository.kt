package com.kripto.appmanager.respository

import com.kripto.appmanager.model.AppwareTerminal
import kotlinx.coroutines.flow.Flow

interface AppwareTerminalRepository {
    suspend fun insert(client: AppwareTerminal):Result<Unit>
    suspend fun getAll(): Result<List<AppwareTerminal>>
    fun flowAll(): Flow<List<AppwareTerminal>>
}