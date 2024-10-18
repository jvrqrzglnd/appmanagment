package com.kripto.appmanager.navigation
import kotlinx.serialization.Serializable

@Serializable
data class StartScrn(val none:Int=0)
//object StartScrn {}

@Serializable
data class HomeScrn(val none:Int=0)
//object HomeScrn {}

@Serializable
data class ClientScrn(val clientId:Int)

@Serializable
data class StoreScrn(val storeId:Int)

@Serializable
data class TerminalScrn(val terminalId:Int)//se puede agregar un modelo como parametro para enviar objeto

@Serializable
data class ChooseeAppwareScrn(val terminalId:Int)

@Serializable
data class ClientRegScrn(val none:Int=0)

@Serializable
data class ResOptScrn(val idClient:Int=0)

@Serializable
object MainGraph