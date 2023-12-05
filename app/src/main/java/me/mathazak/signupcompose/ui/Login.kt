package me.mathazak.signupcompose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun Login(navigateToInfo: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var name by remember { mutableStateOf("") }
        var familyName by remember { mutableStateOf("") }
        var birthDate by remember { mutableStateOf("") }
        var nationalId by remember { mutableStateOf("") }

        TextField(
            value = name,
            onValueChange = { newValue -> name = newValue },
            maxLines = 1,
            placeholder = { Text(text = "Name") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = familyName,
            onValueChange = { newValue -> familyName = newValue },
            maxLines = 1,
            placeholder = { Text(text = "Family Name") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nationalId,
            onValueChange = { newValue -> nationalId = newValue },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "National ID") },
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = navigateToInfo) {
            Text(text = "Login")
        }
    }
}