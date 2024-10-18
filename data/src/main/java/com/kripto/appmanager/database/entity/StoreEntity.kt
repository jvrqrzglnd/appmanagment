package com.kripto.appmanager.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "store")
data class StoreEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "employequantity")
    val employequantity:Int,
    @ColumnInfo(name = "connectivity")
    val connectivity:Int,
    @ColumnInfo(name = "clientid")
    val clientid:Int
)