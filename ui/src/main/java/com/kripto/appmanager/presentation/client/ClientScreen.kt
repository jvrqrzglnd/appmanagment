package com.kripto.appmanager.presentation.client

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kripto.appmanager.model.Store
import com.kripto.appmanager.navigation.ClientScrn

/*class ClientScreen {
    //lista de tiendas del cliente
}*/



@Preview(showBackground = true)
@Composable
fun ClientScreen(
    client: ClientScrn?=null,
    onDetailNavigate: (Store) -> Unit={},
    onEditNavigate: (Store) -> Unit={}
) {

    val stores = (0..3).map{ Store(it,"Tienda $it ",0,0,0) }
    Box(modifier =Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(stores){index,store->

                StoreItem(store,onDetailNavigate,onEditNavigate)
            }
        }
    }
    Box(modifier =Modifier.fillMaxSize().padding(bottom = 64.dp, end = 16.dp),contentAlignment = Alignment.BottomEnd,){
        AddClientButton {
            println("hola")
        }
    }

}
@Composable
fun StoreItem(
    store: Store,
    onDetailNavigate: (Store) -> Unit={},
    onEditNavigate: (Store) -> Unit={})
{

    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp).clickable {
        onDetailNavigate(store)
    }){
        Row(modifier =Modifier.fillMaxWidth().padding(top=16.dp, bottom = 16.dp), verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier.weight(1f),){
                Text(store.name,style= MaterialTheme.typography.labelLarge.copy())
                Box(Modifier.height(8.dp))
                Text("Cantidad de terminales",style= MaterialTheme.typography.labelMedium.copy())
            }
            Button(onClick = {
                onEditNavigate(store)
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
