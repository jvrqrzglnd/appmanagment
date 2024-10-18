package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.TerminalStoreDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.TerminalStore
import com.kripto.appmanager.respository.TerminalStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TerminalStoreRepositoryImpl @Inject constructor(
    private val terminalStoreDataSource: TerminalStoreDataSource
): TerminalStoreRepository {
    override suspend fun insert(terminalStore: TerminalStore): Result<Unit> = runCatching {
        terminalStoreDataSource.insert(terminalStore.toEntity())
    }

    override suspend fun getAll(): Result<List<TerminalStore>>  = runCatching {
        terminalStoreDataSource.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<TerminalStore>> = terminalStoreDataSource.flowAll().map { it.toDomain() }
}