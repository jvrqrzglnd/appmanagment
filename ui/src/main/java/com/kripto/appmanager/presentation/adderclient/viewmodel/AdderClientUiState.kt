package com.kripto.appmanager.presentation.adderclient.viewmodel

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kripto.appmanager.util.Updatable

interface AdderClientUiState {
    val inputClientName:String
    val inputEmployeByStoreCount:String
    val enableRegisterButton:Boolean
    val showLoadingBlock:Boolean
}

class MutableAdderClientUiState():AdderClientUiState, Updatable {
    override var inputClientName: String by mutableStateOf("")
    override var inputEmployeByStoreCount: String by mutableStateOf("")
    override val enableRegisterButton: Boolean by derivedStateOf {
        inputClientName.isNotEmpty() && inputEmployeByStoreCount.isNotEmpty()
    }
    override var showLoadingBlock: Boolean by mutableStateOf(false)

}