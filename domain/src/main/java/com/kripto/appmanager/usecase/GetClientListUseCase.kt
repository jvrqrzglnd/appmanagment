package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Client
import com.kripto.appmanager.respository.ClientRepository
import javax.inject.Inject

class GetClientListUseCase @Inject constructor(
    private  val respository: ClientRepository
) {
    suspend operator fun invoke():Result<List<Client>>  = respository.getAll()
}