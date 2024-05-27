package com.example.afinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.afinal.ui.theme.FinalTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalTheme {
                App(modifier = Modifier)
                
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
//    var num1 = remember {
//        mutableIntStateOf((1..6).random())
//    }
//    var num2 = remember {
//        mutableIntStateOf((1..6).random())
//    }

    val (num1, setNum1) = remember { mutableIntStateOf((1..6).random()) }
    val (num2, setNum2) = remember { mutableIntStateOf((1..6).random()) }
    val arr = arrayOf<Int>(1, 2, 3, 4, 5, 6)

    Scaffold(
        topBar = {
            TopAppBar(
                { Text(text = "Dicee") },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
            )
        },
    ) { it ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (num1 == 1) {
                Image(painter = painterResource(id = R.drawable.dice1), contentDescription = "")
            } else if (num1 == 2) {
                Image(painter = painterResource(id = R.drawable.dice2), contentDescription = "")
            } else if (num1 == 3) {
                Image(painter = painterResource(id = R.drawable.dice3), contentDescription = "")
            } else if (num1 == 4) {
                Image(painter = painterResource(id = R.drawable.dice4), contentDescription = "")
            } else if (num1 == 5) {
                Image(painter = painterResource(id = R.drawable.dice5), contentDescription = "")
            } else if (num1 == 6) {
                Image(painter = painterResource(id = R.drawable.dice6), contentDescription = "")
            }
            if (num2 == 1) {
                Image(painter = painterResource(id = R.drawable.dice1), contentDescription = "")
            } else if (num2 == 2) {
                Image(painter = painterResource(id = R.drawable.dice2), contentDescription = "")
            } else if (num2 == 3) {
                Image(painter = painterResource(id = R.drawable.dice3), contentDescription = "")
            } else if (num2 == 4) {
                Image(painter = painterResource(id = R.drawable.dice4), contentDescription = "")
            } else if (num2 == 5) {
                Image(painter = painterResource(id = R.drawable.dice5), contentDescription = "")
            } else if (num2 == 6) {
                Image(painter = painterResource(id = R.drawable.dice6), contentDescription = "")
            }
            Button(onClick = {
                val chance1 = (1..6).random()
                val chance2 = (1..6).random()
                setNum1(chance1)
                setNum2(chance2)
            }) {
                Text(text = "Shuffle")
            }
        }
    }
}


@Composable
fun App(modifier: Modifier){
    var navController = rememberNavController();

    NavHost(navController = navController, startDestination = "splash"){
        composable(route="splash"){ SplashScreen(navController,modifier=Modifier) }
        composable(route="home"){ HomeScreen(navController,modifier=Modifier) }


    }
}

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {
    LaunchedEffect(Unit) {
        delay(3000) // Wait for 3 seconds
        navController.navigate("home")
    }
    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.baseline_games_24), contentDescription ="logo" )
        Text(text = "Dice Casino")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalTheme {
//        Greeting("Android")
    }
}