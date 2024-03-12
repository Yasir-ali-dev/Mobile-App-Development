package com.example.lab2.ui.theme.ui.theme

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceDataStore
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.preferencesDataStore
import com.example.lab2.ui.theme.ui.theme.ui.theme.MyApplicationTheme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

            }
        }
    }
}

private val Context.dataStore by preferencesDataStore(name = "settings")




//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier,context: Context= LocalContext.current) {
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//
//
////        TextField(value = text, onValueChange = { text = it }, label = { Text("Label") })
//
//        Button(
//            onClick = {
//                val intent =Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mahar.com"))
//                context.startActivity(intent)
//            }
//        ) {
//            Text(text = "Go")
//        }
//
//
//    }
//}

//@Composable
//fun Login (modifier: Modifier){
//    var username by remember {
//        mutableStateOf("")
//    }
//    val context= LocalContext.current
//    var pref:SharedPreferences =context.getSharedPreferences("myprefs",Context.MODE_PRIVATE)
//    var usernamevalue =pref.edit().putString("username","guest")
//    Column(modifier = Modifier.fillMaxSize()) {
//        TextField(value = username, onValueChange = {username=it})
//        Button(
//            onClick = {
//                val editor =pref.edit()
//                editor.putString("username",username)
//                editor .apply()
//                editor.commit()
//            }
//        ) {
//            Text(text = "Save")
//        }
//            Text(text = username)
//
//    }
//}
//
//@SuppressLint("RememberReturnType")
//@Composable
//fun dataStoreFunction (){
//    var context = LocalContext.current
//
//}
//class DataStoreManager(private val context: Context){
//
//}

//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview3() {
//    MyApplicationTheme {
//        Login(modifier = Modifier)
//    }
//}