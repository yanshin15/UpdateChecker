package com.betrbeta.UpdateChecker

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@RequiresApi(Build.VERSION_CODES.O)
fun parseDateString(dateString: String, pattern: String): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern) //formats string with a given pattern
        LocalDate.parse(dateString, formatter)
    } catch (e: DateTimeParseException) {
        null
    }
}