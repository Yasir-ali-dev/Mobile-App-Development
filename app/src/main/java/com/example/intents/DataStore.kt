package com.example.intents

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.intents.ui.theme.IntentsTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStore : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentsTheme {

            }
        }
    }
}

// private val context: Context "class level variable"
class DataStoreManager (private val context: Context){
    val Context.datastore by preferencesDataStore(name = "myprefs")
    val NAME_KEY= stringPreferencesKey("name")

    suspend fun saveName (name: String){
        context.datastore.edit { it[NAME_KEY]=name }
    }

    suspend  fun getName ():String{
       val flow= context.datastore.data.map { it[NAME_KEY] ?: "Guest" };
        return flow.first()
    }

}

@Composable
fun App(name: String, modifier: Modifier = Modifier) {
    var name= remember {
        mutableIntStateOf(0)
    }
    val mgr =DataStoreManager(LocalContext.current)
    var lastSavedName by remember {
        mutableSta
    }
    LaunchedEffect(Unit ){
        lastSavedName=mgr.getName()
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(value = name, onValueChange = {name=it})
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    IntentsTheme {
        App("Android")
    }
}