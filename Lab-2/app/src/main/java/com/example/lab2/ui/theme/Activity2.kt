package com.example.lab2.ui.theme

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab2.ui.theme.ui.theme.MyApplicationTheme

class Activity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview2()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2(context: Context= LocalContext.current) {
    MyApplicationTheme {
        PhoneDialerButton(phoneNumber = "031121777", context=context)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PhoneDialerButton(phoneNumber: String, context: android.content.Context) {
    val uriHandler = LocalUriHandler.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                // Create a Uri from the phone number
                val dialerUri = Uri.parse("tel:$phoneNumber")

                // Create an intent with the action DIAL and the dialer Uri
                val dialerIntent = Intent(Intent.ACTION_DIAL, dialerUri)

                // Start the activity with the dialerIntent
                context.startActivity(dialerIntent)
            }
        ) {
            Text(text = "Dial $phoneNumber")
        }
    }
}