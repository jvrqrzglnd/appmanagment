package com.kripto.appmanager.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "terminal_store")
data class TerminalStoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "storeid")
    val storeid:Int,
    @ColumnInfo(name = "terminalid")
    val terminalid:Int
)