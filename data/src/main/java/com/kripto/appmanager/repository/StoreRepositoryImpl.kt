package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.StoreDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.Store
import com.kripto.appmanager.respository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val storeDataSource: StoreDataSource
): StoreRepository {
    override suspend fun insert(store: Store): Result<Unit> = runCatching {
        storeDataSource.insert(store.toEntity())
    }

    override suspend fun getAll(): Result<List<Store>>  = runCatching {
        storeDataSource.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<Store>> = storeDataSource.flowAll().map { it.toDomain() }
}