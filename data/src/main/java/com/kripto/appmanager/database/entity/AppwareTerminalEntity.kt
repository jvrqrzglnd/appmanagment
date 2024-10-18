package com.kripto.appmanager.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appware_terminal")
data class AppwareTerminalEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "appwareid")
    val appwareid:Int,
    @ColumnInfo(name = "terminalid")
    val terminalid:Int
)