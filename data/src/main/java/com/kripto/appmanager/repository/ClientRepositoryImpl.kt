package com.kripto.appmanager.repository

import com.kripto.appmanager.database.dao.ClientDao
import com.kripto.appmanager.database.dao.ClientDataSource
import com.kripto.appmanager.mapper.toDomain
import com.kripto.appmanager.mapper.toEntity
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.respository.ClientRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val clientDs: ClientDataSource
): ClientRepository {
    override suspend fun insert(client: Client): Result<Unit> = runCatching {
       clientDs.insert(client.toEntity())
    }

    override suspend fun getAll(): Result<List<Client>>  = runCatching {
        clientDs.getAll().getOrThrow().toDomain()
    }

    override fun flowAll(): Flow<List<Client>> = clientDs.flowAll().map { it.toDomain() }
}