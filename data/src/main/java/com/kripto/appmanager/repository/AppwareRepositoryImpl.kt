package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.AppwareDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.Appware
import com.kripto.appmanager.respository.AppwareRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppwareRepositoryImpl @Inject constructor(
    private val appwareDataSource: AppwareDataSource
): AppwareRepository {
    override suspend fun insert(appware: Appware): Result<Unit> = runCatching {
        appwareDataSource.insert(appware.toEntity())
    }

    override suspend fun getAll(): Result<List<Appware>>  = runCatching {
        appwareDataSource.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<Appware>> = appwareDataSource.flowAll().map { it.toDomain() }
}