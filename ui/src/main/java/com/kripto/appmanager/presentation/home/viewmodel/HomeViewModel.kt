package com.kripto.appmanager.presentation.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kripto.appmanager.usecase.FlowAllClientListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val flowAllClientListUseCase: FlowAllClientListUseCase
) :ViewModel(), HomeUiAction{

    private val _uiState = MutableHomeUiState()
    val uiState:HomeUiState =_uiState

    private val _channel = Channel<HomeUiEvent>()
    val channel=_channel.receiveAsFlow()

    init {
        loadClientList()
    }


    fun loadClientList(){
        viewModelScope.launch(Dispatchers.IO){
            flowAllClientListUseCase().onEach {
                _uiState.clients=it
                Log.v("jqg","cantidad de registros ${it.size}")
            }
            .launchIn(viewModelScope)
        }
    }


}