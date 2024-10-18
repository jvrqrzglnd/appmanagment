package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.TerminalStoreEntity
import com.kripto.appmanager.model.TerminalStore

fun TerminalStore.toEntity()=TerminalStoreEntity(id,storeid,  terminalid )

fun TerminalStoreEntity.toDomainModel()=TerminalStore(id,storeid,terminalid)

fun List<TerminalStoreEntity>.toDomain() = map { it.toDomainModel() }