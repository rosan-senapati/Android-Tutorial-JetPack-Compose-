package com.example.application_1

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.application_1.ui.theme.Application1Theme
import com.example.application_1.utils.DataSource
import com.example.application_1.utils.dummyData

class RecyclerViewActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Application1Theme{
                Surface (color = MaterialTheme.colorScheme.background){
                    RecyclerView(users = dummyData())
                }
            }
        }
    }
}



@Composable
fun EachRow(user: DataSource){
        Card(
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(CornerSize(10.dp)),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(modifier = Modifier.padding(10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image",
                    modifier = Modifier.padding(8.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Text(
                    text = user.description,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
}

@Composable
fun RecyclerView(users: List<DataSource>)
{
    LazyColumn(

    ) {
            items(users){user->
                EachRow(user)

            }
    }
}