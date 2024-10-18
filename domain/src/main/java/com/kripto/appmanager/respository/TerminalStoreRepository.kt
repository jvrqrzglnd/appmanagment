package com.kripto.appmanager.respository

import com.kripto.appmanager.model.TerminalStore
import kotlinx.coroutines.flow.Flow

interface TerminalStoreRepository {
    suspend fun insert(client: TerminalStore):Result<Unit>
    suspend fun getAll(): Result<List<TerminalStore>>
    fun flowAll(): Flow<List<TerminalStore>>
}