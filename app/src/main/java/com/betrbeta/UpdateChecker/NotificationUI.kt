package com.betrbeta.UpdateChecker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun NotificationUI(navController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(22, 26, 29))
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(38, 43, 46))
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Image(
                painter = painterResource(id = R.drawable.close_btn),
                contentDescription = "close button",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp, 0.dp, 0.dp, 0.dp)
                    .clickable(
                        onClick = {
                            navController?.navigate(Screen.Home.route)
                        }
                    )
            )
            Spacer(
                modifier = Modifier
                    .width(24.dp)
            )

            Text(
                text = "Notifications", color = Color.White, fontSize = 20.sp
            )

            Spacer(
                modifier = Modifier
                    .width(100.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.check_btn),
                contentDescription = "close button",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(45.dp)
                    .padding(12.dp, 0.dp, 0.dp, 0.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.dot_menu),
                contentDescription = "close button",
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(18.dp, 0.dp, 0.dp, 0.dp)
            )


        }

        Row(
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(60.dp)
                .background(Color(22, 26, 29))
                .padding(10.dp)
        ) {

            Button(
                modifier = Modifier
                    .height(50.dp),
                onClick = {
                    //your onclick code
                },
                border = BorderStroke(1.3.dp, Color(79, 87, 95)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10)
            ) {
                Text(
                    text = "All types ", color = Color.White
                )
                Icon(
                    painter = painterResource(id = R.drawable.drop_down),
                    contentDescription = "drop down"
                )


            }

            Spacer(modifier = Modifier.width(6.dp))

            Button(
                modifier = Modifier
                    .height(50.dp),
                onClick = {
                    //your onclick code
                },
                border = BorderStroke(1.3.dp, Color(79, 87, 95)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(10)
            ) {
                Text(
                    text = "Unread", color = Color.White
                )
            }


        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(text = "June", color = Color.White)
        }

//        LazyColumn(content = )

    }
}