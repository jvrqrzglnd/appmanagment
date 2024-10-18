package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Store
import com.kripto.appmanager.respository.StoreRepository
import javax.inject.Inject

class GetStoreListUseCase @Inject constructor(
    private  val respository:StoreRepository
) {
    suspend operator fun invoke():Result<List<Store>>  = respository.getAll()
}