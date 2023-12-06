package me.mathazak.signupcompose.util

sealed class Screen(val route: String) {
    data object LoginScreen: Screen("LoginScreen")
    data object InfoScreen: Screen("InfoScreen")
}