package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Appware
import com.kripto.appmanager.respository.AppwareRepository
import javax.inject.Inject

class GetAppwareListUseCase @Inject constructor(
    private  val respository: AppwareRepository
) {
    suspend operator fun invoke():Result<List<Appware>>  = respository.getAll()
}