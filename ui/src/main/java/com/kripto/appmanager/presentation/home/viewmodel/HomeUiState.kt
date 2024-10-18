package com.kripto.appmanager.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.util.Updatable

interface HomeUiState {
    val clients:List<Client>
}

class MutableHomeUiState : HomeUiState,Updatable{
    override var clients: List<Client> by mutableStateOf(emptyList())
}