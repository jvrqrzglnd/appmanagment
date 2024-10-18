package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.ClientEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientDataSource  @Inject  constructor(
    private val clientDao: ClientDao
) {

    suspend fun insert(clientEntity: ClientEntity): Result<Long> = runCatching {
        clientDao.insert(clientEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<ClientEntity>> = runCatching {
        clientDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<ClientEntity>> = clientDao.flowAll()
}