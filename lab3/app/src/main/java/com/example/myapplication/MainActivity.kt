package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.w3c.dom.Text
import org.xmlpull.v1.XmlPullParser
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

            }
        }
    }
}


@Composable
fun SignUpScreen (modifier: Modifier,navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    var fullname by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onTertiaryContainer)
    ) {
        OutlinedTextField(
            value = fullname,
            onValueChange = { fullname = it },
            label = { Text("Fullname") },
        )
        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
        )
        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier=Modifier.size(280.dp,35.dp),
            shape = RectangleShape,
            colors= ButtonDefaults.buttonColors(containerColor = Color.Cyan, contentColor = Color.White)

        ) {
            Text(text = "Sign up")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Already have account?"
            )
            TextButton(onClick = {
                navController.navigate("login")
            }) {
                Text(text = "Login in")
            }
        }
    }
}
@Composable
fun LoginScreen (modifier: Modifier, navController: NavController){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
        )
        Spacer(modifier = Modifier.height(7.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier=Modifier.size(280.dp,35.dp),
            shape = RectangleShape

        ) {
            Text(text = "Login")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Not a memeber?"
            )
            TextButton(onClick = {
                navController.navigate("signup")
            }) {
                Text(text = "Sign up now")
            }
        }
    }
}
@Composable
fun AppNavigations (){
    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = "signup" ){
        composable(route="signup"){ SignUpScreen(modifier = Modifier,navController)}
        composable(route = "login"){ LoginScreen(modifier = Modifier,navController)}
    }
}

@Composable
fun FriendsNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "home" ){
        composable(route="home"){ Home(navController = navController, modifier = Modifier)}
        composable(route="chandler"){ChandlerScreen(navController, modifier = Modifier)}
    }
}

@Composable
fun ChandlerScreen(navController: NavController, modifier: Modifier) {

}

@Composable
fun Home (navController: NavController, modifier: Modifier){

     Column(
         modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.SpaceEvenly
     ) {
         Text(
             text = "f",
             fontSize = 50.sp,
             textAlign = TextAlign.Center,
             fontWeight = FontWeight.Bold
         )
         Row {
             Column(
                 modifier=Modifier.clickable { navController.navigate("chandler") }
             ) {
                 Image(
                     painter = painterResource(id = R.drawable.chandler),
                     contentDescription ="chandler",

                 )
                 Text(text = "Chandler")
             }
             Spacer(modifier = Modifier.width(10.dp))
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.phoebe),
                     contentDescription ="phoebe",

                     )
                 Text(text = "phoebe")
             }
         }

         Row {
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.joey),
                     contentDescription ="joey",

                     )
                 Text(text = "Joey")
             }
             Spacer(modifier = Modifier.width(10.dp))
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.monica),
                     contentDescription ="monica",

                     )
                 Text(text = "Monica")
             }
         }

         Row {
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.ross),
                     contentDescription ="ross",

                     )
                 Text(text = "Ross")
             }
             Spacer(modifier = Modifier.width(10.dp))
             Column {
                 Image(
                     painter = painterResource(id = R.drawable.rachel),
                     contentDescription ="rachel",

                     )
                 Text(text = "Rachel")
             }
         }
     }
}


class PreferenceManager (context: Context){
    val sharedPreferences:SharedPreferences = context.getSharedPreferences("myprefs",Context.MODE_PRIVATE)
    fun save(key:String,value:String){
        var edit = sharedPreferences.edit()
        edit.putString(key,value)
        edit.apply()
    }
    fun getValue(key:String) : String{
        return sharedPreferences.getString(key,"Not Found") ?: "Not Found"
    }
}
@Composable
fun PreferenceMethod (modifier: Modifier){
    val context=LocalContext.current

    val preferenceManager= remember {
       PreferenceManager(context)
    }
    var data by remember {
        mutableStateOf(preferenceManager.getValue("name"))
    }
    var value by remember {
        mutableStateOf("")
    }
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        OutlinedTextField(value = value, onValueChange ={value=it})
        Button(onClick = {
            preferenceManager.save("name","Ali")
        }) {
            Text(text = "Save")
        }
        Text(text = preferenceManager.getValue("name"))
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme   {

    }
}