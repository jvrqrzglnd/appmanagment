package com.kripto.appmanager.presentation.start

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kripto.appmanager.navigation.HomeScrn
import com.kripto.appmanager.navigation.StartScrn
import com.kripto.appmanager.theme.AppManagerTheme
import kotlinx.coroutines.delay

//class StartScreen {}
@Preview(showBackground = true)
@Composable
fun StartScreen(onNextNavigate: () -> Unit={}) {
    LaunchedEffect(Unit) {
        delay(1000)
        onNextNavigate()
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.height(400.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Text(text = "Kripto", style=MaterialTheme.typography.titleLarge.copy())
            Text(text = "Gestor de aplicaciones",style=MaterialTheme.typography.headlineMedium.copy())
        }
        /*Row(modifier = Modifier.weight(1f)){

        }*/


    }


}