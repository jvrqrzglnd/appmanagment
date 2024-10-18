package com.kripto.appmanager.presentation.adderclient.viewmodel

interface AdderClientUiAction {
    fun onClientNameTyping(value:String)
    fun onInputEmployeByStoreTyping(value:String)
    fun onSubmit()
}