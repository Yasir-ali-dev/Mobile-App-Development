package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme


class Lab4_3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
//                AppNavigation()
            }
        }
    }
}
@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = "note_app" ){
        composable(route="note_app"){ NoteApp(modifier = Modifier,navController) }
        composable(route = "read"){ ReadData(modifier = Modifier,navController) }
    }
}

@Composable
fun NoteApp( modifier: Modifier = Modifier, navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Notes App", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Button(onClick = {
                context.openFileOutput("notes.txt", Context.MODE_PRIVATE).use {
                    it.write("${text}\n".toByteArray())
                }
                navController.navigate("read")
            }) {
                Text(text = "Save Note")
            }
        }

    }

}

@Composable
fun ReadData(modifier: Modifier,navController: NavController){
    val context = LocalContext.current
    var content by remember {
        mutableStateOf("")
    }
    var tasks = mutableListOf<String>()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Reading From File")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            content= context.openFileInput("notes.txt").bufferedReader().useLines {
                    lines -> lines.fold("") { some, text -> "$some\n$text" }
            }

        }) {
            Text(text = "Show Text")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = content)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyApplicationTheme {

    }
}