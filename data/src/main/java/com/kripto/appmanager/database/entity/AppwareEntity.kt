package com.kripto.appmanager.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appware")
data class AppwareEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "version")
    val version:Int,
    @ColumnInfo(name = "versionname")
    val versionname:String,
    @ColumnInfo(name = "averagedataflow")
    val averagedataflow:Int,

)