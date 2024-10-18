package com.kripto.appmanager.presentation.resopt.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kripto.appmanager.model.Prompt
import com.kripto.appmanager.util.Updatable

interface ResOptUiState {
    val prompts:List<Prompt>
}

class MutableResOptUiState : ResOptUiState,Updatable{
    override var prompts: List<Prompt> by mutableStateOf(emptyList())

}

