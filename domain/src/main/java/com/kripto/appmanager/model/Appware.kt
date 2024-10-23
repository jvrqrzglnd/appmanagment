package com.kripto.appmanager.model
import kotlinx.serialization.Serializable
@Serializable
data class Appware(val id:Int,val name:String,val version:Int=0,val versionname:String="",val averagedataflow:Int=0)