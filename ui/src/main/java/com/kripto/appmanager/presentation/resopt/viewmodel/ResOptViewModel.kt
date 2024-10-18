package com.kripto.appmanager.presentation.resopt.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.kripto.appmanager.model.Prompt
import com.kripto.appmanager.navigation.ResOptScrn
import com.kripto.appmanager.usecase.GetAppwareListUseCase
import com.kripto.appmanager.usecase.GetAppwareTerminalListUseCase
import com.kripto.appmanager.usecase.GetStoreListUseCase
import com.kripto.appmanager.usecase.GetTerminalListUseCase
import com.kripto.appmanager.usecase.GetTerminalStoreListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResOptViewModel @Inject constructor(
    private val getTerminalListUseCase: GetTerminalListUseCase,
    private val getStoreListUseCase: GetStoreListUseCase,
    private val getTerminalStoreListUseCase: GetTerminalStoreListUseCase,
    private val getAppwareListUseCase: GetAppwareListUseCase,
    private val getAppwareTerminalListUseCase: GetAppwareTerminalListUseCase,
    savedStateHandle: SavedStateHandle,
) :ViewModel(), ResOptUiAction{

    val resOptScrn: ResOptScrn=savedStateHandle.toRoute()


    private val _uiState = MutableResOptUiState()
    val uiState:ResOptUiState =_uiState

    private val _channel = Channel<ResOptUiEvent>()
    val channel=_channel.receiveAsFlow()

    init {

        loadPrompts()
    }


    fun loadPrompts(){
        viewModelScope.launch(Dispatchers.IO){
            val promts= arrayListOf<Prompt>()
            val appware_terminal=getAppwareTerminalListUseCase.invoke().getOrNull()?: listOf()
            val appwares=getAppwareListUseCase.invoke().getOrNull()?: listOf()

            val terminals=getTerminalListUseCase.invoke().getOrNull()?: listOf()

            val stores=getStoreListUseCase.invoke().getOrNull()?: listOf()
            val terminalStore=getTerminalStoreListUseCase.invoke().getOrNull()?: listOf()
            val clientStores=stores.filter { store-> store.clientid==resOptScrn.idClient }

            clientStores.forEach { store->
                val terminallByClientByStore=terminalStore.filter { ts-> ts.storeid==store.id }
                val terminalCount=terminallByClientByStore.size
                if(terminalCount==store.employequantity){
                    promts.add(Prompt("Cantidad correcta de terminales en la tienda ${store.name}",1))
                }else{
                    if(terminalCount<store.employequantity){
                        if(terminalCount>=((store.employequantity/2)+1)){
                            promts.add(Prompt("Cantidad de terminales mínima en la tienda ${store.name}",2))

                        }else{
                            promts.add(Prompt("Pocos terminales en la tienda ${store.name}",3))
                        }
                    }else{
                        promts.add(Prompt("Exceso de terminales en la tienda ${store.name}",3))

                    }

                }


                terminallByClientByStore.forEach { terminal ->

                    val terminalinfo=terminals.filter { t->terminal.id==t.id }


                    val appwares_by_terminal=appware_terminal.filter { at->at.terminalid==terminal.id }
                    appwares_by_terminal.forEach { abt->

                        val appwares_info=appwares.filter { a->a.id==abt.appwareid }

                        appwares_info.forEach { app->

                            val apps_by_name=appwares.filter { a-> a.name.contains(app.name) && a.version>app.version}.sortedByDescending { a-> a.version }
                            /*apps_by_name.forEachIndexed { index, appware ->
                                Log.v("jqg","apps_by_name ${index}  - ${appware.versionname}")
                            }*/
                            if(apps_by_name.isNotEmpty()){
                                promts.add(Prompt("La aplicación  ${app.name} necesita ser actualizada al a version ${apps_by_name.first().versionname} en la terminal ${terminalinfo.first().name}",2))
                            }



                        }

                    }


                }

            }






            /*flowAllClientListUseCase().onEach {
                _uiState.prompts=it
                Log.v("jqg","cantidad de registros ${it.size}")
            }
            .launchIn(viewModelScope)*/

            _uiState.prompts=promts
        }
    }


}