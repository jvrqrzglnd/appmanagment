package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.AppwareEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppwareDataSource  @Inject  constructor(
    private val appwareDao: AppwareDao
) {

    suspend fun insert(appwareEntity: AppwareEntity): Result<Long> = runCatching {
        appwareDao.insert(appwareEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<AppwareEntity>> = runCatching {
        appwareDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<AppwareEntity>> = appwareDao.flowAll()
}