package com.betrbeta.UpdateChecker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.betrbeta.UpdateChecker.components.BuildNavGraph
import com.betrbeta.UpdateChecker.ui.theme.UpdateCheckerTheme

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    "channel_id",
                    "Channel name",
                    NotificationManager.IMPORTANCE_HIGH
                )
                val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.createNotificationChannel(channel)
            }

            UpdateCheckerTheme {
                val context = LocalContext.current
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                BuildNavGraph(navController = navController)




            }
        }
        // ATTENTION: This was auto-generated to handle app links.
        val appLinkIntent: Intent = intent
        val appLinkAction: String? = appLinkIntent.action
        val appLinkData: Uri? = appLinkIntent.data
    }



}

