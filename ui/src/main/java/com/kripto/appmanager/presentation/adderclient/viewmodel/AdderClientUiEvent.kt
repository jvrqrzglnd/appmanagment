package com.kripto.appmanager.presentation.adderclient.viewmodel

sealed interface AdderClientUiEvent {
    data object Submit:AdderClientUiEvent
    data object Registered:AdderClientUiEvent
    data object onErrorInput:AdderClientUiEvent
    data object onInoutRight:AdderClientUiEvent
}