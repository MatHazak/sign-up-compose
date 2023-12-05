package me.mathazak.signupcompose.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(startScreen: Screen) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            Login(navigateToInfo = {
                navController.navigate(Screen.InfoScreen.route)
            })
        }
        composable(route = Screen.InfoScreen.route) {
            Info(navigateToLogin = {
                navController.popBackStack(
                    route = Screen.LoginScreen.route,
                    inclusive = false
                )
            })
        }
    }
}