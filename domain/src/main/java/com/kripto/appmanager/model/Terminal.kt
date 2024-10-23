package com.kripto.appmanager.model
import kotlinx.serialization.Serializable
@Serializable
data class Terminal(val id:Int,val name:String,val connectivity:Int=0)