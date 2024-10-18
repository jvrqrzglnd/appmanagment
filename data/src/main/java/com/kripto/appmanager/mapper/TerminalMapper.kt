package com.kripto.appmanager.mapper

import com.kripto.appmanager.database.entity.TerminalEntity
import com.kripto.appmanager.model.Terminal

fun Terminal.toEntity()=TerminalEntity(id,name,  connectivity )

fun TerminalEntity.toDomainModel()=Terminal(id,name,connectivity)

fun List<TerminalEntity>.toDomain() = map { it.toDomainModel() }