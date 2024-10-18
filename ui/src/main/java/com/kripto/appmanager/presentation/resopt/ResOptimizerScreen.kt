package com.kripto.appmanager.presentation.resopt

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.model.Prompt
import com.kripto.appmanager.navigation.ResOptScrn
import com.kripto.appmanager.presentation.resopt.viewmodel.ResOptViewModel
import com.kripto.appmanager.util.firstCap

@Composable
fun ResOptimizerScreen(
    resOptString: ResOptScrn,
    viewModel: ResOptViewModel = hiltViewModel(),
) {

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(viewModel.uiState.prompts){index,prompt->

                PromptItem(prompt)
            }
        }
    }
}

@Composable
fun PromptItem(
    prompt: Prompt,
    onDetailNavigate: (Client) -> Unit={},
    onEditNavigate: (Client) -> Unit={})
{

    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp).clickable {
        //corregir prompt si es flag 2?
    }){
        Row(modifier =Modifier.fillMaxWidth().padding(top=16.dp, bottom = 16.dp), verticalAlignment = Alignment.CenterVertically){
            if(prompt.flag==1){
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "ok"
                )
            }else if(prompt.flag==2){
                Icon(
                    imageVector = Icons.Filled.Warning,
                    contentDescription = "adevertencia"
                )
            }else if(prompt.flag==3){
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "arreglar",
                )
            }
            Box(
                Modifier.width(8.dp)
            )
            Column(modifier = Modifier.weight(1f),){
                Text(prompt.label.firstCap(),style= MaterialTheme.typography.labelSmall.copy())
                //Box(Modifier.height(8.dp))
                //Text(text = stringResource(R.string.home_screen_item_subtitle,"${client.maxEmployeByStore}"),style= MaterialTheme.typography.labelMedium.copy())

            }
            Box(
                Modifier.width(8.dp)
            )
            Button(onClick = {
                //corregir prompt si es flag 2?
            }) {
                Icon(Icons.Filled.Build, "fix")
            }
        }
    }
}