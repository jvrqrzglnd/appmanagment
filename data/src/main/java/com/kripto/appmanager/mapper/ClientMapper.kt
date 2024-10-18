package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.ClientEntity
import com.kripto.appmanager.model.Client

fun Client.toEntity()=ClientEntity(id,name,  maxEmployeByStore)

fun ClientEntity.toDomainModel()=Client(id,name,maxemployebystore)

fun List<ClientEntity>.toDomain() = map { it.toDomainModel() }