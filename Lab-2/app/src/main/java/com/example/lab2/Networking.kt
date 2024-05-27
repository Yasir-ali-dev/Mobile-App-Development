package com.example.lab2

import android.os.Bundle
import android.util.Log
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.MyApplicationTheme
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class Networking : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

class ResponseHandler :Callback{
    override fun onFailure(call: Call, e: IOException) {
    }
    override fun onResponse(call: Call, response: Response) {
        Log.d("response",response.body?.string() ?:" no response")
    }
}


@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val okHttp = OkHttpClient()

    Column {
        Button(onClick = {
            val request =Request.Builder().url("https://fakestoreapi.com/products/").build()
            okHttp.newCall(request).enqueue(ResponseHandler())
        }) {
            Text(text = "Get Data")
        }
        Button(onClick = {
            val requestBody =FormBody.Builder()
                .add("title","Hello")
                .add("price","700")
                .add("description","hello")
                .add("image","https://i.pravatar.cc")
                .add("category","Games").build()
            val request =Request.Builder()
                .url("https://fakestoreapi.com/products")
                .post(requestBody).build()
            okHttp.newCall(request).enqueue(ResponseHandler())
        }) {
            Text(text = "Post Data")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview7() {
    MyApplicationTheme {
        Greeting2("Android")
    }
}