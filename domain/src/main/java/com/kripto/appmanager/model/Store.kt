package com.kripto.appmanager.model
import kotlinx.serialization.Serializable
@Serializable
data class Store(val id:Int,val name:String,val employequantity:Int=0,val connectivity:Int,val clientid:Int)