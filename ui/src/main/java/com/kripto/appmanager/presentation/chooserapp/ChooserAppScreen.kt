package com.kripto.appmanager.presentation.chooserapp

//class ChooserAppScreen

//lista de aplicaciones que es posible asignar a una terminal


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
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
import androidx.navigation.NavHostController
import com.kripto.appmanager.model.Appware
import com.kripto.appmanager.model.Client
import com.kripto.appmanager.model.Store
import com.kripto.appmanager.model.Terminal
import com.kripto.appmanager.navigation.ChooseeAppwareScrn
import com.kripto.appmanager.navigation.ClientScrn
import com.kripto.appmanager.navigation.StoreScrn
import com.kripto.appmanager.navigation.TerminalScrn

//lista de aplicacione de la terminal
@Preview(showBackground = true)
@Composable
fun ChooserAppwareScreen(
    terminal: ChooseeAppwareScrn?=null,
    onDetailNavigate: (Appware) -> Unit={},
    onEditNavigate: (Appware) -> Unit={}
) {

    val appwares = (0..3).map{ Appware(it,"Appware $it ") }
    Box(modifier =Modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(appwares){index,appware->

                AppwareItem(appware,onDetailNavigate,onEditNavigate)
            }
        }
    }


}
@Composable
fun AppwareItem(
    appware: Appware,
    onChooseNavigate: (Appware) -> Unit={},
    onDetailNavigate: (Appware) -> Unit={})
{

    Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp).clickable {
        onDetailNavigate(appware)
    }){
        Row(modifier =Modifier.fillMaxWidth().padding(top=16.dp, bottom = 16.dp), verticalAlignment = Alignment.CenterVertically){
            Column(modifier = Modifier.weight(1f),){
                Text(appware.name,style= MaterialTheme.typography.labelLarge.copy())
                Box(Modifier.height(8.dp))
                Text("version...",style= MaterialTheme.typography.labelMedium.copy())
            }
            Button(onClick = {
                onDetailNavigate(appware)
            }) {
                Icon(Icons.Filled.Info, "i")
            }

            Button(onClick = {
                onChooseNavigate(appware)
            }) {
                Icon(Icons.Filled.Check, "c")
            }
        }
    }
}

