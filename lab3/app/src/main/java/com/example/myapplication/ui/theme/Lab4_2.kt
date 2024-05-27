package com.example.myapplication.ui.theme

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapplication.ui.theme.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class Lab4_2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MyApp(dataMgr = MyDatastoreManager(LocalContext.current), modifier = Modifier)
            }
        }
    }
}

//class DataStoreManager (private val context:Context){
//    val Context.datastore by preferencesDataStore(name = "myprefs")
//    val counter = intPreferencesKey("counter")
//
//    suspend  fun incrementCounter (count:Int){
//        context.datastore.edit { it[counter]= count}
//    }
//
//    suspend fun getCounter():Int{
//        var dataFlow =context.datastore.data.map {
//            it[counter]
//        }
//        return dataFlow.first()?:0
//    }
//}
//
//@Composable
//fun AppScreen (dataMgr :DataStoreManager, modifier: Modifier){
//    var count by remember {
//        mutableStateOf(0)
//    }
//
//    var value by remember {
//        mutableStateOf(0)
//    }
//
//    LaunchedEffect(Unit){
//        value=dataMgr.getCounter()
//    }
//
//    val scope = rememberCoroutineScope()
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Data Store Manager")
//        Button(onClick = {
//            count++
//            scope.launch { dataMgr.incrementCounter(count) }
//
//        }) {
//            Text(text = "Increment")
//        }
//        Spacer(modifier = Modifier.height(30.dp))
//        Text(text = "$value")
//    }
//}

class MyDatastoreManager(private val context : Context){
    val Context.datastore by preferencesDataStore(name = "PrefernceDataStore")
    val NAME = stringPreferencesKey("name")

    suspend fun SaveName(name:String){
        context.datastore.edit {
            it[NAME] = name
        }
    }

    suspend fun GetName() :  Flow<String?>{
        return  context.datastore.data.map {
            it[NAME]
        }

    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier, dataMgr : MyDatastoreManager){
    var value by remember {
        mutableStateOf("")
    }
    var lastValue = ""
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit){
        val flow = dataMgr.GetName()
        flow.collect { name ->
            lastValue = name ?: ""
        }
    }
    Column {
        OutlinedTextField(value = value, onValueChange = {
            value = it
        })
        Button(onClick = {
            scope.launch {
                dataMgr.SaveName(value)
            }
//Save value in preferences

        }) {
            Text("Save")
        }
        Text(lastValue)
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MyApplicationTheme {

    }
}