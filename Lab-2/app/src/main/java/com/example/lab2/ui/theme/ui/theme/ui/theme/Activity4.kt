package com.example.lab2.ui.theme.ui.theme.ui.theme

import android.os.Bundle
import android.view.RoundedCorner
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.R
import com.example.lab2.ui.theme.ui.theme.ui.theme.ui.theme.MyApplicationTheme

class Activity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {

            }
        }
    }
}

@Composable
fun TextFunction(name: String, modifier: Modifier = Modifier) {
    Column (modifier=Modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Monospace
        )
        Text(
            text = buildAnnotatedString {
                append("hello")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                           colors =  listOf(
                                Color.Red,
                                Color.Blue,
                                Color.Green
                            )
                        )
                    )
                ){
                    append(" sajid sahab weds vandana")
                }
                append(" Bajaj")
            },
            fontSize = 34.sp,
            lineHeight = 35.sp
        )
    }
}

@Composable
fun ButtonComponents (modifier: Modifier){
    Column (modifier=Modifier.fillMaxSize()){
        Button(
            onClick = { /*TODO*/ },
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.Cyan
            ),
            contentPadding = PaddingValues(15.dp)
        ) {
            Text(text = "Sajid")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "outlined-button")
        }

        FilledTonalButton(
            onClick = { /*TODO*/ },
            colors=ButtonDefaults.buttonColors(
                containerColor = Color.Magenta
            ),
            contentPadding = PaddingValues(12.dp)
        ) {
            Text(text = "Tonal Button")
        }

        ElevatedButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "elevated")
        }

        TextButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(contentColor = Color.Cyan)
        ) {
            Text(text = "text-button")
        }
    }
}

@Composable
fun ImageComponent(modifier: Modifier){
    Column (modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.iron),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .border(BorderStroke(1.dp, Color.Cyan))
                .clip(RectangleShape)
        )
        Icon(Icons.Sharp.Menu, contentDescription = "Menu")
        Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription ="icon" )
    }
}

@Composable
fun LayoutComponents(modifier: Modifier){
    Column (modifier=Modifier.fillMaxSize() ){
        Column (
            horizontalAlignment = AbsoluteAlignment.Left,
            modifier = Modifier.fillMaxWidth()
            ) {
            Text(
                text = "Alfred Sisley",
                fontSize = 40.sp
            )
            Text(
                text ="3 minutes ago",
                color = Color.Gray,
                fontSize = 20.sp
            )
        }
        Row(modifier = Modifier.padding(top = 17.dp, bottom = 17.dp)){
            Image(
                painter = painterResource(id = R.drawable.loki),
                contentDescription ="loki",
                modifier.clip(CircleShape)
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Alfred Sisley",
                    fontSize = 40.sp
                )
                Text(
                    text = "3 minutes ago",
                    color = Color.Gray,
                    fontSize = 20.sp
                )
            }
        }
    }



}

@Composable
fun BoxLayout (modifier: Modifier){
    Box(
        modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.iron),
            contentDescription = "",
            Modifier
                .clip(RectangleShape)
                .size(150.dp)
        )
        Icon(
            Icons.Filled.AddCircle,
            contentDescription ="Icon",
            modifier=Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Composable
fun ModifierComponents(modifier : Modifier){
    Row (
        modifier = Modifier.size(width = 270.dp, height = 220.dp
        )){
        Text(
            text = "Hello Modifier",
            modifier
                .paddingFromBaseline(top = 40.sp)
                .padding(horizontal = 20.dp)
                .offset(x = 5.dp)
        )
    }
}

@Composable
fun SurfaceComponents (modifier: Modifier){
    Surface (
        modifier= Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentColor = Color.Magenta,
        border = BorderStroke(2.dp, Color.Green),
        shadowElevation = 18.dp,
        color = Color.White,

    ){
        Text(text = "hi",modifier.padding(12.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldComponent(modifier: Modifier){
    Scaffold (

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    Icon(Icons.Sharp.Menu, contentDescription ="menu" )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor =MaterialTheme.colorScheme.primary
                ),
                actions = {
                    Icon(Icons.Filled.ArrowBack, contentDescription ="<-" )
                    Icon(Icons.Filled.AccountCircle, contentDescription ="-" )
                    Icon(Icons.Filled.ArrowForward, contentDescription ="->" )
                },



            )
        },
        bottomBar = {
                    BottomAppBar (
                        containerColor = Color.Magenta,
                        contentColor = Color.Unspecified
                    ){
                        Text(text = "Bottom App Bar")
                    }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon( Icons.Filled.Add, contentDescription = "")
            }
        }
    ) {
        innerPadding ->
        Column(modifier=Modifier.padding(innerPadding)) {

        }
    }
}

@Composable
fun CardExample() {
    Card() {
        Text(text = "Hello, world!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    MyApplicationTheme {
        ScaffoldComponent(modifier = Modifier)
    }
}