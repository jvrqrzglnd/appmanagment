package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Client
import com.kripto.appmanager.respository.ClientRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlowAllClientListUseCase @Inject constructor(
    private  val repository: ClientRepository
) {
    operator fun invoke(): Flow<List<Client>> = repository.flowAll()
}