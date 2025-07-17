package com.csaim.swipeme.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csaim.swipeme.viewModel.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun UserScreen(viewModel: UserViewModel = viewModel()) {

    val user by viewModel.user.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Card(
                    modifier = Modifier
                        .clip(CircleShape)

                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(120.dp)
                        ,
                        model = user?.picture?.large,
                        contentDescription = "user?.picture?.large"

                    )
                }


               Column(
                   modifier = Modifier
                       .padding(16.dp),
               ) {
                   Text(

                       text = "${user?.name?.title} ${user?.name?.first} ${user?.name?.last}",
                       fontSize = 18.sp
                   )
                   Spacer(modifier = Modifier.height(8.dp))
                   Text(
                       text = "e-mail: ${user?.email}",
                   )
                   Text("Cell: ${user?.cell}")
               }

            }

            Button(
                onClick = {
                    viewModel.fetchUser()
                }
            ) {
                Text("next user")
            }
        }
    }


}