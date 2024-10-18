package com.kripto.appmanager.respository

import com.kripto.appmanager.model.Terminal
import kotlinx.coroutines.flow.Flow

interface TerminalRepository {
    suspend fun insert(client: Terminal):Result<Unit>
    suspend fun getAll(): Result<List<Terminal>>
    fun flowAll(): Flow<List<Terminal>>
}