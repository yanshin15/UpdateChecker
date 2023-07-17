package com.betrbeta.UpdateChecker

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.betrbeta.UpdateChecker.ui.theme.UpdateCheckerTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpdateCheckerTheme {
                // A surface container using the 'background' color from the theme
                UpdateCheckUI()
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun UpdateCheckUI() {
    val developerUpdatedOn = remember { mutableStateOf("") }
    val userUpdatedOn = remember { mutableStateOf("") }

    val (isAppOutdated, daysOutOfDate) = checkUpdateStatus(developerUpdatedOn.value, userUpdatedOn.value)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = if (isAppOutdated) "The installed app is out of date." else "The installed app is up to date.")

        if (isAppOutdated) {
            Text(text = "Days out of date: $daysOutOfDate")
        }

        OutlinedTextField(
            modifier = Modifier.padding(4.dp),
            value = developerUpdatedOn.value,
            onValueChange = { developerUpdatedOn.value = it },
            placeholder = { Text(text = "Last Developer update date (DD-MM-YYYY)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        OutlinedTextField(
            modifier = Modifier.padding(4.dp),
            value = userUpdatedOn.value,
            onValueChange = { userUpdatedOn.value = it },
            placeholder = { Text(text = "Last User update date (DD-MM-YYYY)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun checkUpdateStatus(developerUpdateDate: String, userUpdateDate: String): Pair<Boolean, Long> {
    val developerDate = parseDateString(developerUpdateDate, "dd-MM-yyyy")
    val userDate = parseDateString(userUpdateDate, "dd-MM-yyyy")

    val isAppOutdated = developerDate != null && userDate != null && developerDate.isAfter(userDate)
    val daysOutOfDate = if (isAppOutdated) ChronoUnit.DAYS.between(userDate, developerDate) else 0

    return Pair(isAppOutdated, daysOutOfDate)
}

@RequiresApi(Build.VERSION_CODES.O)
fun parseDateString(dateString: String, pattern: String): LocalDate? {
    return try {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        LocalDate.parse(dateString, formatter)
    } catch (e: DateTimeParseException) {
        null
    }
}
