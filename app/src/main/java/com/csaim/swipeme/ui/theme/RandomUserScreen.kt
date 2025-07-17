package com.csaim.swipeme.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.csaim.swipeme.viewModel.RandomUserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun RandomUserScreen(viewModel: RandomUserViewModel = viewModel()) {

    val user by viewModel.randomUser.collectAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchUser()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        user?.let { u ->
            // Profile Picture
            AsyncImage(
                model = u.picture.large,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name
            Text(
                text = "${u.name.title} ${u.name.first} ${u.name.last}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Email
            Text(
                text = u.email,
                style = MaterialTheme.typography.bodyMedium
            )

            Button(
                onClick = {
                    viewModel.fetchUser()
                }
            ) {
                Text("Next User")
            }
        } ?: run {
            Text("Loading user...")
        }
    }
}
