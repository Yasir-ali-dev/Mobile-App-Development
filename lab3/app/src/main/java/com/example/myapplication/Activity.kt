package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.io.OutputStreamWriter
import java.nio.charset.Charset

class Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                App()
            }
        }
    }
}


fun WriteInToFile ( context: Context){
    try {
        context.openFileOutput("example.txt", Context.MODE_PRIVATE).use {
            it.write(("Example content of the library hi therer i am  here" +
                    "hi hi").toByteArray())
        }
        Log.i("myClass","writeed ")
    }
    catch (e:Exception){
        print("$e")
    }
}

fun ReadFile(context: Context):String{
    try {
        val content = context.openFileInput("example.txt").bufferedReader().useLines {
            lines ->
            lines.fold("") { some, text ->
                "$some\n$text"
            }
        }
        return content
    }catch (e:Exception){
        Log.i("Myclass","error")
        return "not found"
    }
}

@Composable
fun App(){
    val context = LocalContext.current
    WriteInToFile(context)
    val read= ReadFile(context)
    Column {
        Text(text = "he, $read")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        App()
    }
}