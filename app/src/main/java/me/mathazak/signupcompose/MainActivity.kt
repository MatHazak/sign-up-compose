package me.mathazak.signupcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import me.mathazak.signupcompose.ui.Navigation
import me.mathazak.signupcompose.ui.Screen
import me.mathazak.signupcompose.ui.theme.SignUpComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(startScreen = Screen.LoginScreen)
                }
            }
        }
    }
}

@Preview(widthDp = 320, heightDp = 680)
@Composable
fun MyApp() {
    SignUpComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Navigation(startScreen = Screen.LoginScreen)
        }
    }
}