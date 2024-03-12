package com.example.lab2


import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.MyApplicationTheme
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme

            }
        }
    }
}


@Composable
fun TaskTwo(name: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "1",
            modifier= Modifier
                .clip(RoundedCornerShape(10.dp))
                .weight(1f)
        )
        Column(modifier = Modifier
            .padding(10.dp)
            .weight(2f), verticalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Yasir Ali",
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = "0212-2172777",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

        }
    }
}

@Composable
fun TaskThree(name: String, modifier: Modifier = Modifier) {
    Column (modifier=Modifier.background(color = Color.LightGray)){
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.iron),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Iron Man",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 43",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.spider),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Spider Man",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 30",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.thor),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Thor",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 35",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.harley),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Harley Queen",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 27",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.loki),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Loki",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 29",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
        Row(modifier= Modifier
            .padding(3.dp)
            .background(color = Color.White)) {
            Image(
                painter = painterResource(R.drawable.logan),
                contentDescription = "1",
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .size(90.dp)
                    .weight(1f)
            )
            Column(
                modifier = Modifier
                    .weight(2f), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Wolverine",
                    fontSize = 35.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(1.dp))
                Text(
                    text = "Age: 89",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}

@Composable
fun TaskFour(name: String, modifier: Modifier = Modifier) {
    Column {
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box (modifier = Modifier
                .weight(1f)
                .padding(5.dp)) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.spider),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = "Dhaka",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
            Box (modifier = Modifier
                .weight(1f)
                .padding(5.dp)
                .fillMaxWidth()) {
                Card (
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.fillMaxWidth()
                ){
                    Column(   modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.mount),
                            contentDescription ="",
                            modifier= Modifier
                                .padding(2.dp)
                                .fillMaxWidth()
                        )
                        Text(text = "Dhaka", textAlign = TextAlign.Center,modifier=Modifier.padding(5.dp) )
                    }

                }
            }
        }
    }
}


@Composable
fun changeColor() {
    var buttonClicked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Button(
            onClick = { buttonClicked = !buttonClicked },
            modifier = Modifier
                .height(45.dp)
                .width(120.dp),
            colors = ButtonDefaults.buttonColors(if (buttonClicked) Color.Green else Color.Red),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "Click Me", fontSize = 18.sp, color = Color.Black)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        changeColor()
    }
}