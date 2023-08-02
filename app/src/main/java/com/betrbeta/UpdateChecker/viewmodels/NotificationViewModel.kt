package com.betrbeta.UpdateChecker.viewmodels

import androidx.lifecycle.ViewModel
import com.betrbeta.UpdateChecker.models.Notifications

class NotificationViewModel : ViewModel() {

    private val notifications = mutableListOf<Notifications>()

    init {
        notifications.add(Notifications("This is a sample notification", "Test Noti"))
    }

    fun getNotifications(): List<Notifications> {
        return notifications
    }
}
