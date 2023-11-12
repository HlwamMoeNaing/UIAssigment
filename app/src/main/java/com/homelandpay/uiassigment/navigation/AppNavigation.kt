package com.homelandpay.uiassigment.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.homelandpay.uiassigment.ui.screen.DetailScreen
import com.homelandpay.uiassigment.ui.screen.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HOME){
        composable(Routes.HOME){
            HomeScreen(navController = navController)
        }
        composable(Routes.DETAIL_SCREEN){
            DetailScreen(navController = navController)
        }
    }
}