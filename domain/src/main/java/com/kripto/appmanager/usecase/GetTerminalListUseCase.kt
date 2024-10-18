package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Terminal
import com.kripto.appmanager.respository.TerminalRepository
import javax.inject.Inject

class GetTerminalListUseCase @Inject constructor(
    private  val respository: TerminalRepository
) {
    suspend operator fun invoke():Result<List<Terminal>>  = respository.getAll()
}