package com.kripto.appmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kripto.appmanager.navigation.HomeScrn
import com.kripto.appmanager.navigation.MainNavHost
import com.kripto.appmanager.navigation.StartScrn
import com.kripto.appmanager.navigation.TopBarNavigation
import com.kripto.appmanager.presentation.home.HomeScreen
import com.kripto.appmanager.presentation.start.StartScreen
import com.kripto.appmanager.theme.AppManagerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootAtivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val navController=rememberNavController()

            AppManagerTheme {
               AppContent(navController)
            }
        }
    }
}

@Composable
fun AppContent( navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBarNavigation(navController = navController) },
        ) { innerPadding ->
        println("jqg innerPadding $innerPadding")

        Surface (modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)){
            MainNavHost(navController)
        }
        /*Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )*/
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(navController: NavHostController?=null) {
    AppManagerTheme {
        navController?.let {
            AppContent(it)
        }

    }
}