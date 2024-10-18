package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.AppwareTerminalEntity
import com.kripto.appmanager.model.AppwareTerminal

fun AppwareTerminal.toEntity()=AppwareTerminalEntity(id,appwareid,  terminalid)

fun AppwareTerminalEntity.toDomainModel()=AppwareTerminal(id,appwareid,  terminalid)

fun List<AppwareTerminalEntity>.toDomain() = map { it.toDomainModel() }