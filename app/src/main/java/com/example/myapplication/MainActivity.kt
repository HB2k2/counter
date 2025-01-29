package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CounterApp();
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterApp() {
    var counter by remember { mutableIntStateOf(0) }

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Scaffold( modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Counter App") },
            )
        }
    ) { innerPadding ->
        Column (
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ){
            Spacer(modifier = Modifier.height(screenHeight/8))
            Text(text = "$counter",
                fontSize = 64.sp ,
                fontWeight = FontWeight.Bold,
                );
            Spacer(modifier = Modifier.height(screenHeight/4))
            Button(onClick = { counter++; }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)  ) {
                Text("Increment")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { if (counter>0){ counter--;} }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)  ) {
                Text("Decrement")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { counter=0; }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)  ) {
                Text("Reset")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        CounterApp();
    }
}