package com.betrbeta.UpdateChecker

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

    //FCM Token: c-OizY5WQ-WgrxR5gxyJXp:APA91bGl5efWgXaOXHcNb78pMQ1pG0xtY9p0V7DLDSTfi6MdYUS-YUtdgAYPU190HzXIqHaB5mVBvUabC5VykZwo-HlqTU-I_tUz1XaAJDJ9-LLQheEzalJ9Yl7hEDWz1L_1gwVjWz8f

class FCMService : FirebaseMessagingService() {
    val tag: String = "FCMToken"
    override fun onNewToken(token: String) {


        Log.d(tag, "FCM token: $token")
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // ...
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(tag, "From: ${remoteMessage.from}")


        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(tag, "Message Notification Body: ${it.body}")
            val notification = showNotification(it.title.toString(), it.body.toString())

            }

        }

    fun showNotification(title:String, content:String){
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = NotificationCompat.Builder(this, "channel_id")
            .setContentTitle(title)
            .setContentText(content)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()

        notificationManager.notify(1, notification)


    }
}


        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.

