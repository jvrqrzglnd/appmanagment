package com.kripto.appmanager.presentation.adderclient.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.usecase.GetClientListUseCase
import com.kripto.appmanager.usecase.RegisterClientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdderClientViewModel @Inject constructor(
    private val registerClientUseCase: RegisterClientUseCase
):ViewModel(),AdderClientUiAction{

    private val _uiState= MutableAdderClientUiState()
    val uiState:AdderClientUiState=_uiState

    private val _channel = Channel<AdderClientUiEvent>()
    val channel=_channel.receiveAsFlow()


    override fun onClientNameTyping(value: String) {
        _uiState.inputClientName = value

    }

    override fun onInputEmployeByStoreTyping(value: String) {
        _uiState.inputEmployeByStoreCount=value
    }

    override fun onSubmit() {
        _uiState.showLoadingBlock=true
        viewModelScope.launch(Dispatchers.IO) {
            delay(500)
            registerClientUseCase.invoke(Client(0,_uiState.inputClientName,_uiState.inputEmployeByStoreCount.toInt()))
            _channel.send(AdderClientUiEvent.Registered)
        }
    }

}