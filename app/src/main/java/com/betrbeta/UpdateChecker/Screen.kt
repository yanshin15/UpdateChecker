package com.betrbeta.UpdateChecker

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Notification: Screen(route = "notification_screen")


}