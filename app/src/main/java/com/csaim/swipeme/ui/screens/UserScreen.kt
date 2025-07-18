package com.csaim.swipeme.ui.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csaim.swipeme.viewModel.CardViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun UserScreen(viewModel: CardViewModel = viewModel()) {

    val user by viewModel.user.collectAsState()
    val dog by viewModel.dog.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCard()
    }

    Column (
        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize()
            .background(Color.Gray)
            .statusBarsPadding()
    ) {
        Card(
            modifier = Modifier
                .weight(3f)
                .fillMaxSize()
                .padding(16.dp)

        ) {

            AsyncImage(
                model = dog?.message,
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxSize(),


            )
        }
        Card  (
            modifier = Modifier
                .padding(bottom = 16.dp)
//                .weight(1f)
                .padding(horizontal = 16.dp),
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.tertiary

            )
        ){
            Row (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Card(
                    modifier = Modifier
                        .clip(CircleShape),
//                        .padding(23.dp)
//                        .weight(1f)
//                        .background(Color.Red),


                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(100.dp)
                        ,
                        model = user?.picture?.large,
                        contentDescription = "user?.picture?.large"

                    )
                }


               Column(
                   modifier = Modifier
                       .weight(3f)
                       .padding(horizontal = 16.dp),
               ) {
                   Text(

                       text = "Owner: ${user?.name?.title} ${user?.name?.first} ${user?.name?.last}",
                       fontSize = 18.sp
                   )
                   Spacer(modifier = Modifier.height(8.dp))
                   Text(
                       text = "e-mail: ${user?.email}",
                   )
                   Text("Cell: ${user?.cell}")
               }

            }




        }
            Button(
                onClick = {
                    viewModel.fetchCard()
                }
            ) {
                Text("next user")
            }

    }


}