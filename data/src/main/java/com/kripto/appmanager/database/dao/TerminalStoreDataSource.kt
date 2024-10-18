package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.TerminalStoreEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TerminalStoreDataSource  @Inject  constructor(
    private val terminalStoreDao: TerminalStoreDao
) {

    suspend fun insert(terminalStoreEntity: TerminalStoreEntity): Result<Long> = runCatching {
        terminalStoreDao.insert(terminalStoreEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<TerminalStoreEntity>> = runCatching {
        terminalStoreDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<TerminalStoreEntity>> = terminalStoreDao.flowAll()
}