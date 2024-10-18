package com.kripto.appmanager.database.dao

import android.util.Log
import com.kripto.appmanager.database.entity.StoreEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoreDataSource  @Inject  constructor(
    private val storeDao: StoreDao
) {

    suspend fun insert(storeEntity: StoreEntity): Result<Long> = runCatching {
        storeDao.insert(storeEntity)
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to insert $it" )
    }

    suspend fun getAll(): Result<List<StoreEntity>> = runCatching {
        storeDao.getAll()
    }.onFailure {
        Log.e(this::class.simpleName,"Failure to getAll $it" )
    }

    fun flowAll(): Flow<List<StoreEntity>> = storeDao.flowAll()
}