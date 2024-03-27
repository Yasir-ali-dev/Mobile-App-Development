package com.example.intents

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.intents.ui.theme.IntentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntentsTheme {
                PrefernceComposable()
            }
        }
    }
}


/// Intent 

@Composable
fun IntentsComponents(modifier: Modifier){
    var context= LocalContext.current
    Column (modifier = Modifier.fillMaxSize()){
        Text(text = "Main Activity")
        Button(onClick = {
            val intent: Intent = Intent(context,Activity::class.java)
            intent.putExtra("name","Danyal")
            intent.putExtra("ID",5)
            context.startActivity(intent)
        }) {
            Text("To Activity")
        }

    }
}





@Composable
fun CameraExample(modifier: Modifier){
    var context= LocalContext.current
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){
        isGranted -> if(isGranted){
         Toast.makeText(context,"Permission Granted",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Permission Denied",Toast.LENGTH_SHORT).show()
        }
    }
    Button(onClick = {
        if(ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED
        ){
            Toast.makeText(context, "Permission is already Granted", Toast.LENGTH_SHORT).show()
        }else{
            requestPermissionLauncher.
            launch(android.Manifest.permission.CAMERA)
        }
    }) {
        Text(text = "open camera")
    }

}












///             NavController

@Composable
fun App(modifier: Modifier){
    var navController = rememberNavController();
    var profileArgs = listOf(navArgument("profileId"){
        type=NavType.StringType
    })
    NavHost(navController = navController, startDestination = "home"){
        composable(route="home"){HomeScreen(navController)}
        composable(route="profile"){ProfileScreen(navController) }
        composable(route="profile/{profileId}", arguments = profileArgs){
            backEntryStack ->
            var profileId=backEntryStack.arguments?.getString("profileId")
            ProfileDetail(navController,profileId)

        }
    }

}
@Composable
fun HomeScreen(navController: NavController){
    Column {
        Text(text = "Home Screen")
        Button(onClick = {
            navController.navigate("profile")
        }) {
            Text(text = "To Profile")
        }
        Button(onClick = {
            navController.navigate("profile/profile123")
        }) {
            Text(text = "To Profile")
        }
    }
}
@Composable
fun ProfileDetail(navController: NavController, profileId:String?){
    Column {
        Text(text = "Profile Detail $profileId")
        Button(onClick = {
            navController.navigate("profile/profile543")
        }) {
            Text(text = "To Profile")
        }
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text(text = "To Home")
        }
    }
}
@Composable
fun ProfileScreen(navController: NavController){
    Column {
        Text(text = "Profile Screen")
        Button(onClick = {
            navController.navigate("home")
        }) {
            Text(text = "To Home")
        }
    }
}
















///             PrefernceManager


class PrefernceManager(context: Context){
    private val sharedPreferences:SharedPreferences=
        context.getSharedPreferences("prefs",Context.MODE_PRIVATE)

    fun saveData(key:String,value:String){
        val editor= sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
        editor.commit()
    }
    fun saveAge(key:String,value:Int){
        val editor= sharedPreferences.edit()
        editor.putInt(key,value)
        editor.apply()
        editor.commit()
    }

    fun getData (key:String, defaultString : String):String{
        return sharedPreferences.getString(key,defaultString)?:defaultString
    }

    fun getAge (key:String, defaultAge : Int):Int{
        return sharedPreferences.getInt(key,defaultAge)?:defaultAge
    }
}

@Composable
fun PrefernceComposable(){
    var context= LocalContext.current

    val preferenceManager= remember {
      PrefernceManager(context)
    }

    preferenceManager.saveData("name","Ali Khan")
    preferenceManager.saveAge("Ali",15)

    var data = remember {
        mutableIntStateOf(preferenceManager.getAge("Ali",10))
    }

    Column {
        Text(text = "name ${preferenceManager.getData("name","Ali")}")
        Text(text = "data ${data.value}")

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntentsTheme {
        IntentsComponents(modifier = Modifier)
    }
}