package com.betrbeta.UpdateChecker.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.betrbeta.UpdateChecker.NotificationUI
import com.betrbeta.UpdateChecker.UpdateCheckUI


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BuildNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route) {
            UpdateCheckUI(navController = navController)
        }
        composable(route = Screen.Notification.route) {
            NotificationUI(navController = navController)
        }

    }
}
