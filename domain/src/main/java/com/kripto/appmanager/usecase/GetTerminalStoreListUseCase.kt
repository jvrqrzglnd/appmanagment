package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.TerminalStore
import com.kripto.appmanager.respository.TerminalStoreRepository
import javax.inject.Inject

class GetTerminalStoreListUseCase @Inject constructor(
    private  val respository: TerminalStoreRepository
) {
    suspend operator fun invoke():Result<List<TerminalStore>>  = respository.getAll()
}