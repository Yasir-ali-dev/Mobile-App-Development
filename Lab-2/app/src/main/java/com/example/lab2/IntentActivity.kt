package com.example.lab2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.MyApplicationTheme
import com.example.lab2.ui.theme.ui.theme.ui.theme.Activity4

class IntentActivity :ComponentActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

            }
        }
    }
}
@Composable
fun IntentsComponents(modifier: Modifier){
    var context= LocalContext.current
    Column (modifier = Modifier.fillMaxSize()){
        Button(onClick = {
            val intent:Intent = Intent(context,Activity4::class.java)
            context.startActivity(intent)
        }) {
            Text("Send Message to Details")
        }
        Text(text = "fdfd")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    MyApplicationTheme {
        IntentsComponents(modifier = Modifier)
    }
}