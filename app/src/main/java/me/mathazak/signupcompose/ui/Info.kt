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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import me.mathazak.signupcompose.R

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
        Text(text = stringResource(R.string.first_name, userInfo.value.firstName))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.last_name, userInfo.value.lastName))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.birth_date, userInfo.value.birthDate))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(R.string.national_id, userInfo.value.nationalId))
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                viewModel.logout()
                navigateToLogin()
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = stringResource(R.string.logout))
        }
    }
}