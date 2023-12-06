package me.mathazak.signupcompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Info(
    navigateToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InfoViewModel = viewModel()
) {
    val userInfo = viewModel.userInfo.collectAsState()
    Column(
        modifier = modifier.padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(text = "First Name: ${userInfo.value.firstName}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Last Name: ${userInfo.value.lastName}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Birth Date: ${userInfo.value.birthDate}")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "National ID: ${userInfo.value.nationalId}")
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                viewModel.logout()
                navigateToLogin()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Logout")
        }
    }
}