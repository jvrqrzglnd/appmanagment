package com.kripto.appmanager.navigation

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.kripto.appmanager.presentation.adderclient.AdderClientScreen
import com.kripto.appmanager.presentation.chooserapp.ChooserAppwareScreen
import com.kripto.appmanager.presentation.client.ClientScreen
import com.kripto.appmanager.presentation.home.HomeScreen
import com.kripto.appmanager.presentation.resopt.ResOptimizerScreen
import com.kripto.appmanager.presentation.start.StartScreen
import com.kripto.appmanager.presentation.store.StoreScreen
import com.kripto.appmanager.presentation.terminal.TerminalScreen

@Composable
fun MainNavHost(
    navController: NavHostController/* = rememberNavController()*/,
) {


    NavHost(navController=navController, startDestination =StartScrn()){

        composable<StartScrn>() {
            StartScreen(onNextNavigate = {
                //Check sesion ready if not go to startsesion screen
                navController.navigate(HomeScrn()){
                    popUpTo(StartScrn()) {
                        inclusive = true
                    }
                }
            })
        }
        mainGraph(navController)

    }

}

private fun NavGraphBuilder.mainGraph(navController: NavHostController){

    navigation<MainGraph>(startDestination = HomeScrn()){
        composable<HomeScrn>() {
            HomeScreen(navController,{
                navController.navigate(ClientScrn(it.id))
            },{

                //pantalla de edición de cliente
            },{
                navController.navigate(ClientRegScrn(0))
            })
        }
        composable<ClientScrn>() {backStackEntry ->
            val data:ClientScrn=backStackEntry.toRoute()

            ClientScreen(data,{
                navController.navigate(StoreScrn(it.id))
            },{
                //pantalla de edicion tienda
            })
        }

        composable<ClientRegScrn>() {backStackEntry ->
            //val data:ClientRegScrn=backStackEntry.toRoute()

            AdderClientScreen(onBackNavigate = {
                navController.popBackStack()
            })
        }

        composable<StoreScrn>() {backStackEntry ->
            val data:StoreScrn=backStackEntry.toRoute()

            StoreScreen(data,{
                navController.navigate(TerminalScrn(it.id))
            },{
               //pantalla de edicion terminal
            })
        }

        composable<TerminalScrn>() {backStackEntry ->
            val data:TerminalScrn=backStackEntry.toRoute()

            TerminalScreen(data,{
                //detalle de aplicacion?
            },{
                navController.navigate(ChooseeAppwareScrn(0))
            })
        }

        composable<ChooseeAppwareScrn> {  backStackEntry ->
            val data:ChooseeAppwareScrn=backStackEntry.toRoute()

            ChooserAppwareScreen(data,{
                navController.popBackStack()
                //retroceder con app agregada
            },{
                //detall e aplicacion?
            })
        }

        composable<ResOptScrn>() { backStackEntry ->
            val data:ResOptScrn=backStackEntry.toRoute()
            ResOptimizerScreen(data)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var currentRoute = navBackStackEntry?.destination?.route

    var title= ""
    if((currentRoute?:"").isNotBlank()){
        currentRoute=currentRoute?.substringBefore("/")?.substringBefore("?")?:""

        when(currentRoute){
            //StartScrn.Companion::class.java.declaringClass.name -> "" //no seria necesario
            HomeScrn.Companion::class.java.declaringClass.name ->{
                title="Lista de clientes"
            }
            ClientScrn.Companion::class.java.declaringClass.name -> {
                var client=navBackStackEntry?.toRoute<ClientScrn>()
                title="Cliente ${client?.clientId}"
            }
            StoreScrn.Companion::class.java.declaringClass.name ->{
                var store=navBackStackEntry?.toRoute<StoreScrn>()
                title="Tienda ${store?.storeId}"
            }
            TerminalScrn.Companion::class.java.declaringClass.name ->{
                var terminal=navBackStackEntry?.toRoute<TerminalScrn>()
                title="Terminal ${terminal?.terminalId}"
            }
            ChooseeAppwareScrn.Companion::class.java.declaringClass.name ->{
                var terminal=navBackStackEntry?.toRoute<TerminalScrn>()
                title="Agrega applicación al terminal X"
            }

            ClientRegScrn.Companion::class.java.declaringClass.name ->{
                title="Registra un nuevo cliente"
            }
            ResOptScrn.Companion::class.java.declaringClass.name ->{
                title="Optimizador de recursos"
            }
            else->{
                title="no match"
            }
        }
    }

    //val bottomNavigationItemRouteList = listOf(HOME_SCREEN, FAVORITE_SCREEN)

    /*val title = when (currentRoute) {
        HOME_SCREEN -> stringResource(id = R.string.screen_home_title)
        FAVORITE_SCREEN -> stringResource(id = R.string.screen_favorite_title)
        DETAIL_SCREEN -> stringResource(id = R.string.screen_detail_title)
        else -> ""
    }*/

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,//currentRoute?:"sin titulo",
                color = Color.White
            )
        },
        //backgroundColor = colorResource(id = R.color.colorPrimaryDark),
        navigationIcon =
        {
            if (navController.previousBackStackEntry != null) {

                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        tint = Color.White,
                        contentDescription = null
                    )
                }

            }
        },
        actions = {
            if(!(currentRoute?:"").lowercase().contains("opti") && (currentRoute?:"").lowercase().contains("client")){
                IconButton(onClick = {

                    val param=navBackStackEntry?.toRoute<ClientScrn>()?:ClientScrn(0)

                    navController.navigate(ResOptScrn(param.clientId))
                }) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Fix resources"
                    )
                }
            }

        },

    )
}