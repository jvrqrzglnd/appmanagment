package com.kripto.appmanager.usecase

import com.kripto.appmanager.model.Client
import com.kripto.appmanager.respository.ClientRepository
import javax.inject.Inject

class RegisterClientUseCase @Inject constructor(
    private  val respository:ClientRepository
) {
    suspend operator fun invoke(client:Client):Result<Unit>  = respository.insert(client)
}