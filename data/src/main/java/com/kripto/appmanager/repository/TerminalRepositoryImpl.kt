package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.TerminalDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.Terminal
import com.kripto.appmanager.respository.TerminalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TerminalRepositoryImpl @Inject constructor(
    private val terminalDataSource: TerminalDataSource
): TerminalRepository {
    override suspend fun insert(terminal: Terminal): Result<Unit> = runCatching {
        terminalDataSource.insert(terminal.toEntity())
    }

    override suspend fun getAll(): Result<List<Terminal>>  = runCatching {
        terminalDataSource.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<Terminal>> = terminalDataSource.flowAll().map { it.toDomain() }
}