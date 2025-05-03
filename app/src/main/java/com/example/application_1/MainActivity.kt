package com.example.application_1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application_1.ui.theme.Application1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Application1Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Demo App 1")
                            },
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Menu, contentDescription = "menu")
                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        Icons.Filled.Notifications,
                                        contentDescription = "notification"
                                    )
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Search, contentDescription = "search")
                                }
                            }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            Icon(Icons.Filled.Add, contentDescription = "add")
                        }
                    },
                    floatingActionButtonPosition = FabPosition.End
                ) {paddingValues ->
                    // Apply the padding here
                    ShowSwitch(modifier = Modifier.padding(paddingValues))
//                    Greeting(name = "Rosan", modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Preview(showBackground = true, name = "light mode")
@Preview(
    showBackground = true,
    name = "dark mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun GreetingPreview() {
    Application1Theme {
        Greeting("Android")
    }
}

@Composable
fun ShowSwitch(modifier: Modifier = Modifier) {
    val isChecked = remember { mutableStateOf(true) }
    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = modifier.size(40.dp) // Increased size for visibility
    )
}


