package com.elitecodecamp.mausam.presentation.ui

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.elitecodecamp.mausam.R
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionViewModel
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherViewModel
import com.elitecodecamp.mausam.presentation.ui.theme.MausamTheme
import com.elitecodecamp.navigationdrawer.drawer.AppDrawerItemInfo
import com.elitecodecamp.navigationdrawer.drawer.DrawerContent
import com.elitecodecamp.navigationdrawer.drawer.MainNavOption
import com.elitecodecamp.navigationdrawer.drawer.mainGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(

    predictionViewModel: PredictionViewModel,
    weatherViewModel: WeatherViewModel,
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    lifecycleCoroutineScope: LifecycleCoroutineScope
) {

    MausamTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    DrawerContent(
                        drawerState = drawerState,
                        menuItems = DrawerParams.drawerButtons,
                        defaultPick = MainNavOption.TodayScreen
                    ) { onUserPickedOption ->
                        when (onUserPickedOption) {
                            MainNavOption.TodayScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.PredictionScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.SignInScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                        }
                    }
                }
            ){
                NavHost(
                    navController,
                    startDestination = NavRoutes.MainRoute.name
                ) {
                    mainGraph(drawerState,predictionViewModel,weatherViewModel)
                }
            }

        }
    }

}

enum class NavRoutes {
    MainRoute,
}
object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.TodayScreen,
            R.string.drawer_home,
            R.drawable.ic_today,
            R.string.drawer_home_description
        ),
        AppDrawerItemInfo(
            MainNavOption.PredictionScreen,
            R.string.drawer_prediction,
            R.drawable.ic_prediction,
            R.string.drawer_prediction_description
        )
    )
}