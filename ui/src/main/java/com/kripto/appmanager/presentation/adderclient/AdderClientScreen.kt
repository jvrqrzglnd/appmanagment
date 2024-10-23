package com.kripto.appmanager.presentation.adderclient

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kripto.appmanager.composables.AnimationType
import com.kripto.appmanager.composables.LoadingButton
import com.kripto.appmanager.composables.LockUi
import com.kripto.appmanager.presentation.adderclient.viewmodel.AdderClientUiEvent
import com.kripto.appmanager.presentation.adderclient.viewmodel.AdderClientUiState
import com.kripto.appmanager.presentation.adderclient.viewmodel.AdderClientViewModel
import com.kripto.appmanager.presentation.adderclient.viewmodel.MutableAdderClientUiState
import kotlinx.coroutines.launch
import kotlin.math.max

@Composable
fun AdderClientScreen(
    viewModel: AdderClientViewModel= hiltViewModel(),
    onBackNavigate: () -> Unit={},
) {
    var isError by rememberSaveable { mutableStateOf(false) }
    //val context=LocalContext.current
    val uiState = viewModel.uiState
    LaunchedEffect(Unit) {
        viewModel.channel.collect{ event->
            when(event){
                AdderClientUiEvent.Registered -> {
                    onBackNavigate()
                }
                AdderClientUiEvent.Submit ->{

                }

                AdderClientUiEvent.onErrorInput -> {
                    isError=true
                   // Toast.makeText(context,"Ingresar un número mayora cero por favor",Toast.LENGTH_SHORT).show()
                }

                AdderClientUiEvent.onInoutRight -> {
                    isError=false
                }
            }

        }
    }
    AdderClientScreenUi(viewModel,uiState,isError)
}

@Composable
fun AdderClientScreenUi(
    viewModel: AdderClientViewModel?=null,
    uiState: AdderClientUiState,
    isError:Boolean
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxWidth()
            ,verticalArrangement = Arrangement.spacedBy(16.dp)) {

            OutlinedTextField(
                maxLines = 1,
                value = uiState.inputClientName,
                onValueChange = { viewModel?.onClientNameTyping(it) },
                label = { Text("Nombre del cliente") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                maxLines = 1,
                value = uiState.inputEmployeByStoreCount,
                onValueChange = { viewModel?.onInputEmployeByStoreTyping(it) },
                label = { Text("Máximo de empleados por tienda") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                supportingText ={
                    if(isError){
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Ingresar número mayor a 0",
                            color = MaterialTheme.colorScheme.error
                        )
                    }

                }
            )

            SubmitButton({
                keyboardController?.hide()
                viewModel?.onSubmit()
            },uiState.showLoadingBlock,uiState.enableRegisterButton)
        }
    }

    if(uiState.showLoadingBlock){
        LockUi()
    }

}


@Composable
fun SubmitButton(click: () -> Unit={},loading:Boolean,enable:Boolean) {
    LoadingButton(
        onClick = { click()},
        modifier = Modifier
            .padding(all = 16.dp),
        animationType = AnimationType.Bounce,
        loading = loading,
        enabled = enable
    ) {
        Text(text = "Registrar Cliente")
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewAdderClientScreenUi(){
    AdderClientScreenUi(null,MutableAdderClientUiState(),false)
}