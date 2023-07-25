package com.betrbeta.UpdateChecker

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
fun checkUpdateStatus(developerUpdateDate: String, userUpdateDate: String): Pair<Boolean, Long> {
    val developerDate =
        parseDateString(developerUpdateDate, "ddMMyyyy") //dashes are removed here to take input
    val userDate = parseDateString(userUpdateDate, "ddMMyyyy")

    val isAppOutdated = developerDate != null && userDate != null && developerDate.isAfter(userDate)
    val daysOutOfDate = if (isAppOutdated) ChronoUnit.DAYS.between(userDate, developerDate) else 0

    return Pair(isAppOutdated, daysOutOfDate)
}