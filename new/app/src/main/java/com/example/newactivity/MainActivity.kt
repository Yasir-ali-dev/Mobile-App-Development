package com.example.newactivity

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newactivity.ui.theme.NewActivityTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewActivityTheme {

                App(modifier = Modifier)
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {
    LaunchedEffect(Unit) {

        delay(3000) // Wait for 3 seconds

        // code to be called after 3 seconds
        navController.navigate("city")
    }

    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription ="" )
        Text(text = "Sky Sight")
    }
}


@Composable
fun App(modifier: Modifier){
    var navController = rememberNavController();
    var weatherArgs = listOf(navArgument("weatherArgs"){
        type= NavType.StringType
    })
    NavHost(navController = navController, startDestination = "splash"){
        composable(route="splash"){ SplashScreen(navController) }
        composable(route="city"){ CityScreen(navController, modifier = Modifier) }
        composable(route="weather/{weatherArgs}", arguments = weatherArgs){
                backEntryStack ->
            var weather=backEntryStack.arguments?.getString("weatherArgs")
            Weather(navController,weather, modifier = Modifier)

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityScreen (navController: NavController,modifier: Modifier){
    var name="karachi"

    Scaffold (
        topBar = {
            TopAppBar({Text(text = "Select City")})
        },
        bottomBar = {
            BottomAppBar {
                Image(imageVector = Icons.Filled.Favorite, contentDescription ="" )
            }
        }
    ){
        it->  Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(it),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription ="" )
        Image(
            painter = painterResource(id =  R.drawable.map),
            contentDescription = "map",
            modifier=Modifier.size(300.dp,200.dp)
        )
        TextField(value = name, onValueChange ={name=it} )
        Button(onClick = {
            navController.navigate("weather/$name")
        }) {
            Text(text = "Show Weather")
        }
    }

    }

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Weather (navController: NavController,weather:String?,modifier: Modifier){
    val weatherInfo: List<String> = run {

        val resourceId = LocalContext.current.resources .getIdentifier("weather_info_${weather}", "array", LocalContext.current.packageName)

        if (resourceId != 0) LocalContext.current.resources.getStringArray(resourceId).toList() else listOf("Info not available")

    }

    Scaffold (
        topBar = {
            TopAppBar({Text(text = "Weather Details")})
        },
    ){
        it->
    Column(
        modifier= Modifier
            .fillMaxSize()
            .padding(it),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "City Name: $weather",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier= Modifier.padding(bottom = 10.dp)
        )
        Text(text = "${weatherInfo}")
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.baseline_thermostat_24), contentDescription = "")
            Column (
                verticalArrangement = Arrangement.Center,
                modifier=Modifier.padding(start = 15.dp)
            ){
                Text(text = "Temperature")
                Text(text = "32")
            }
        }
        Row (
            modifier= Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){
            Image(painter = painterResource(id = R.drawable.baseline_wind_power_24), contentDescription ="" )
            Column(
                verticalArrangement = Arrangement.Center,
                modifier=Modifier.padding(start = 15.dp)
            ) {
                Text(text = "Humidity")
                Text(text = "70%")
            }
        }
        Row (
            modifier= Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ){
            Image(painter = painterResource(id = R.drawable.baseline_sunny_24), contentDescription ="" )
            Column (
                verticalArrangement = Arrangement.Center,
                modifier=Modifier.padding(start = 15.dp)
            ){
                Text(text = "Condition")
                Text(text = "Sunny")
            }
        }
    }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewActivityTheme {

        App(modifier = Modifier)
    }
}