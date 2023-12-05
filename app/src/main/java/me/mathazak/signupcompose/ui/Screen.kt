package me.mathazak.signupcompose.ui

sealed class Screen(val route: String) {
    data object LoginScreen: Screen("LoginScreen")
    data object InfoScreen: Screen("InfoScreen")
}