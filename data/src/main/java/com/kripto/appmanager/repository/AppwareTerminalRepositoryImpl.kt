package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.AppwareTerminalDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.AppwareTerminal
import com.kripto.appmanager.respository.AppwareTerminalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppwareTerminalRepositoryImpl @Inject constructor(
    private val appwareTerminalDataSource: AppwareTerminalDataSource
): AppwareTerminalRepository {
    override suspend fun insert(appwareTerminal: AppwareTerminal): Result<Unit> = runCatching {
        appwareTerminalDataSource.insert(appwareTerminal.toEntity())
    }

    override suspend fun getAll(): Result<List<AppwareTerminal>>  = runCatching {
        appwareTerminalDataSource.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<AppwareTerminal>> =
        appwareTerminalDataSource.flowAll().map { it.toDomain() }
}