package com.betrbeta.UpdateChecker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateCheckUI(navController : NavHostController) {
    val developerUpdatedOn = remember { mutableStateOf("") }
    val userUpdatedOn = remember { mutableStateOf("") }

    val (isAppOutdated, daysOutOfDate) = checkUpdateStatus(
        developerUpdatedOn.value,
        userUpdatedOn.value
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(240, 240, 240)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(android.graphics.Color.rgb(240, 240, 240))),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.noti_icon),
                    contentDescription = "Notification",
                    modifier = Modifier.clickable(
                        onClick = {
                            navController?.navigate(Screen.Notification.route)
                        })
                )
            }

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                text = if (isAppOutdated) "The installed app is out of date."
                else "The installed app is up to date."
            )

            if (isAppOutdated) {
                Text(text = "Days out of date: $daysOutOfDate")
            }

            OutlinedTextField(
                modifier = Modifier
                    .padding(4.dp),
                value = developerUpdatedOn.value,
                onValueChange = { developerUpdatedOn.value = it },
                placeholder = { Text(text = stringResource(R.string.devUpdateString)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = DateTransform(),
                singleLine = true
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(4.dp),
                value = userUpdatedOn.value,
                onValueChange = { userUpdatedOn.value = it },
                placeholder = { Text(text = stringResource(R.string.userUpdateString)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = DateTransform(), //makes input visually have dashes
                singleLine = true
            )
        }
    }
}