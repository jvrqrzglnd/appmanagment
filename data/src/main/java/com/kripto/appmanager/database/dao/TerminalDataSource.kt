package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.TerminalEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TerminalDataSource  @Inject  constructor(
    private val terminalDao: TerminalDao
) {

    suspend fun insert(terminalEntity: TerminalEntity): Result<Long> = runCatching {
        terminalDao.insert(terminalEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<TerminalEntity>> = runCatching {
        terminalDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<TerminalEntity>> = terminalDao.flowAll()
}