package com.kripto.appmanager.model
import kotlinx.serialization.Serializable
@Serializable
data class Client(val id:Int,val name:String,val maxEmployeByStore:Int=0)