package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme

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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        AppNavigations()
    }
}