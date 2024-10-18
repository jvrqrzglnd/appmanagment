package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.StoreEntity
import com.kripto.appmanager.model.Store

fun Store.toEntity()=StoreEntity(id,name,  employequantity,connectivity,clientid)

fun StoreEntity.toDomainModel()=Store(id,name,  employequantity,connectivity,clientid)

fun List<StoreEntity>.toDomain() = map { it.toDomainModel() }