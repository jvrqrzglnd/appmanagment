package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.AppwareTerminalEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppwareTerminalDataSource  @Inject  constructor(
    private val appwareTerminalDao: AppwareTerminalDao
) {

    suspend fun insert(appwareTerminalEntity: AppwareTerminalEntity): Result<Long> = runCatching {
        appwareTerminalDao.insert(appwareTerminalEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<AppwareTerminalEntity>> = runCatching {
        appwareTerminalDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<AppwareTerminalEntity>> = appwareTerminalDao.flowAll()
}