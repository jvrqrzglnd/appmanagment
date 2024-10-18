package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.AppwareEntity
import com.kripto.appmanager.model.Appware

fun Appware.toEntity()=AppwareEntity(id,name,  version,versionname,averagedataflow)

fun AppwareEntity.toDomainModel()=Appware(id,name,  version,versionname,averagedataflow)

fun List<AppwareEntity>.toDomain() = map { it.toDomainModel() }