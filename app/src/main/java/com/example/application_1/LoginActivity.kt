package com.example.application_1

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.application_1.ui.theme.Application1Theme

class LoginActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Application1Theme{
                    Surface(color =  MaterialTheme.colorScheme.background) {
                        LoginScreen()
                    }
            }
        }
    }
}

private fun logged(context: Context, username:String, password:String){
    if (username == "test@gmail.com" && password == "Test@123"){
        Toast.makeText(context,"Logged in Successfully",Toast.LENGTH_SHORT).show()
    }
    else{
        Toast.makeText(context,"Invalid Credenrials",Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun LoginScreen(){
    val context = LocalContext.current
    val username = remember{
        mutableStateOf("")
    }
    val password = remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center
    )
    {
        Text(text = "Hello Again",color = Color.Blue, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        Text(text = "Welcome",color = Color.Blue, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        Text(text = "Back",color = Color.Blue, fontSize = 20.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value=username.value,
            onValueChange ={
                username.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription="person")
            },
            label = {
                Text(text="username")
            },
            placeholder = {
                Text(text = "Enter Your Username")
            },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value=password.value,
            onValueChange ={
                password.value = it
            },
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription="info")
            },
            label = {
                Text(text="username")
            },
            placeholder = {
                Text(text = "Enter Your Username")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedButton(onClick = {logged(context,username.value,password.value)}, modifier = Modifier.fillMaxWidth()) {
            Text(text="Login")
        }
    }
}