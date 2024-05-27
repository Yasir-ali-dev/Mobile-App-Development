package com.example.myapplication

import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.format.TextStyle
import android.Manifest
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

class ContentActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                val context =  LocalContext.current

                    Greeting("Android", modifier=Modifier,context=context)

            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,  context:Context ) {
    val contacts = getAllContacts(context)
    Log.d("mess","$contacts")
    LazyColumn(content = {
        items(contacts){
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
                Text(text = it!!.name)
                Text(text = it!!.phone)
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .border(1.dp, Color.Black))
        }
    })
}

data class Contact(val name: String,val phone: String)

fun getAllContacts(context: Context) : List<Contact?>{
    val contactsList = mutableListOf<Contact>()
    if(context.checkSelfPermission(Manifest.permission.READ_CONTACTS) !=
        PackageManager.PERMISSION_GRANTED){
        //require permisson
        return contactsList
    }
    else{

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        val cursor = context.contentResolver.query(
            uri,
            projection,
            null,
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val phone = it.getString(0)
                val name = it.getString(1)
                val contact = Contact(name, phone)
                contactsList.add(contact)
            }
        }
        return contactsList
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {

    }
}