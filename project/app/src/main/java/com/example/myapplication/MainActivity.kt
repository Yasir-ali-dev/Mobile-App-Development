package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme

                    App()

            }
        }
    }
}
@Composable
fun App (){
    val navController= rememberNavController()
    var navArgs = listOf(navArgument("navId"){type= NavType.StringType})
    val texts=listOf("Text 1", "Text 2", "Text 3", "Text 4", "Text 5")
   NavHost(navController = navController, startDestination = "testing" ){
       composable(route="screen"){ FlashScreen( navController=navController)}
       composable(route="home"){Home(navController=navController)}
       composable(route="teacher"){TeacherLoginScreen(navController=navController)}
       composable(route="student"){ StudentLoginScreen(navController = navController)}
       composable(route="teacher_dashboard"){TeacherDashboard(navController=navController)}
       composable(route="student_dashboard"){ StudentDashboard(navController = navController)}
       composable(route="testing/{navId}", arguments = navArgs) { backEntryStack ->
           var userId = backEntryStack.arguments?.getString("navId")?:"not found"
           TestComponent(userId=userId, navController = navController)
//           RenderTexts(texts =  texts, navController=navController)}
       }
       composable(route="testing"){ RenderTexts(texts,navController = navController) }

   }
}

@Composable
fun TestComponent (userId:String, navController: NavController){
    Column {
        Text(text = userId)
    }
}

data class MyObject(val id :Int , val question :String )

fun addObjectToList(list: MutableList<MyObject>, id: Int, name: String) {
    val newObject = MyObject(id, name)
    list.add(newObject)
}


@Composable
fun RenderTexts(texts: List<String>, navController: NavController) {
    var count = remember {
        mutableIntStateOf(0)
    }


    val myObjects = listOf(
        MyObject(1, "Object 1"),
        MyObject(2, "Object 2"),
        MyObject(3, "Object 3"),
        MyObject(4, "Object 4"),
        MyObject(5, "Object 5")
    )
    myObjects.forEach{


    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 15.dp)
    ) {
        Button(onClick = {
            val text = texts[3]
            navController.navigate("testing/$text")

        }) {
            Text(text = "Next")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentDashboard(navController: NavController){
    Scaffold (
        topBar = { TopAppBar(
                title = { Text(
                    text = "Welcome To Quiz App",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Blue
                    )
                }
        )}
    ){
        it->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 7.dp, vertical = 10.dp)
                    .background(Color(android.graphics.Color.parseColor("#33FFFF")))

                    .clip(RectangleShape)
            ){
                Text(
                    text = "What is amazing general knowledge about Pakistan",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp, vertical = 70.dp)
                    )
            }
            Column(
              modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 5.dp, vertical = 15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 7.dp, vertical = 5.dp)
                        .fillMaxWidth()
                        .background(Color(android.graphics.Color.parseColor("#ADD8E6")))

                ) {
                    Text(text = "1920")
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 7.dp, vertical = 5.dp)
                        .fillMaxWidth()
                        .background(Color(android.graphics.Color.parseColor("#ADD8E6")))

                ) {
                    Text(text = "1920")
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 7.dp, vertical = 5.dp)
                        .fillMaxWidth()
                        .background(Color(android.graphics.Color.parseColor("#ADD8E6")))

                ) {
                    Text(text = "1920")
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(horizontal = 7.dp, vertical = 5.dp)
                        .fillMaxWidth()
                        .background(Color(android.graphics.Color.parseColor("#ADD8E6")))

                ) {
                    Text(text = "1920")
                    RadioButton(selected = false, onClick = { /*TODO*/ })
                }
            }
            ElevatedButton(onClick = { /*TODO*/ }) {
                Text(text = "Submit", modifier = Modifier.width(200.dp), textAlign = TextAlign.Center)
            }
        }
    }
}

@Composable
fun TeacherDashboard(navController: NavController){}

@Composable
fun TeacherLoginScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.create), contentDescription ="" )
        Column {
            Text(text = "Enter Username")
            OutlinedTextField(value = "", onValueChange ={} )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Enter Password")
            OutlinedTextField(value = "", onValueChange ={} )
        }
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Submit", modifier = Modifier.width(200.dp), textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun StudentLoginScreen(navController: NavController){
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.quiz_student), contentDescription ="" )
        Column {
            Text(text = "Enter Your Name")
            OutlinedTextField(value = "", onValueChange ={} )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Enter Key")
            OutlinedTextField(value = "", onValueChange ={} )
        }    
        ElevatedButton(onClick = { /*TODO*/ }) {
            Text(text = "Start", modifier = Modifier.width(200.dp), textAlign = TextAlign.Center)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController){
    Scaffold(

        topBar = { TopAppBar(title = { Text(text = "Welcome To Quiz App", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth(), color = Color.Blue)}) }
    ) {
        it->
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,

                ){
                Image(
                    painter = painterResource(id = R.drawable.create),
                    contentDescription = "creator",
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(200.dp)
                        .height(150.dp)

                )
                Spacer(modifier = Modifier.height(7.dp))
                OutlinedButton(onClick = {
                    navController.navigate("teacher")
                }) {
                    Text(text = "Teacher")
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "student",
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(200.dp)
                        .height(150.dp)

                )
                Spacer(modifier = Modifier.height(7.dp))
                OutlinedButton(onClick = {
                    navController.navigate("student")
                }) {
                    Text(text = "Student")
                }
            }
        }

    }

}

@Composable
fun FlashScreen( navController: NavController, modifier: Modifier = Modifier) {
    val coroutineScope= rememberCoroutineScope()
    LaunchedEffect(Unit ){
        coroutineScope.launch {
            delay(5000)
            navController.navigate("home")
        }
    }
    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.quizizz), contentDescription ="quiz" )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        App()
    }
}