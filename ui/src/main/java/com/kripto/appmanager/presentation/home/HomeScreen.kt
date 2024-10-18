package com.kripto.appmanager.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.presentation.home.viewmodel.HomeViewModel
import com.kripto.appmanager.ui.R
import com.kripto.appmanager.util.firstCap


//lista de clientes
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    navController: NavHostController?=null,
    onDetailNavigate: (Client) -> Unit={},
    onEditNavigate: (Client) -> Unit={},
    onRegisterNavigate: () -> Unit={},
    viewModel: HomeViewModel = hiltViewModel(),
) {

    LaunchedEffect(Unit) {
        viewModel.loadClientList()
    }

    //val clients = (0..3).map{ Client(it,"cliente $it ")}
    Box(modifier =Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(viewModel.uiState.clients){index,client->

                ClientItem(client,onDetailNavigate,onEditNavigate)
            }
        }
    }
    Box(modifier =Modifier.fillMaxSize().padding(bottom = 64.dp, end = 16.dp),contentAlignment = Alignment.BottomEnd,){
        AddClientButton {
            onRegisterNavigate()
        }
    }

}





@Composable
fun ClientItem(
    client:Client,
    onDetailNavigate: (Client) -> Unit={},
    onEditNavigate: (Client) -> Unit={})
{

    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp).clickable {
        onDetailNavigate(client)
    }){
        Row(modifier =Modifier.fillMaxWidth().padding(top=16.dp, bottom = 16.dp), verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier.weight(1f),){
                Text(client.name.firstCap(),style= MaterialTheme.typography.labelLarge.copy())
                Box(Modifier.height(8.dp))
                Text(text = stringResource(R.string.home_screen_item_subtitle,"${client.maxEmployeByStore}"),style= MaterialTheme.typography.labelMedium.copy())

            }
            Button(onClick = {
                onEditNavigate(client)
            }) {
                Icon(Icons.Filled.Edit, "+")
            }
        }
    }
}

@Composable
fun AddClientButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, "+")
    }
}
