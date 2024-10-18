package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.AppwareTerminal
import com.kripto.appmanager.respository.AppwareTerminalRepository
import javax.inject.Inject

class GetAppwareTerminalListUseCase @Inject constructor(
    private  val respository: AppwareTerminalRepository
) {
    suspend operator fun invoke():Result<List<AppwareTerminal>>  = respository.getAll()
}