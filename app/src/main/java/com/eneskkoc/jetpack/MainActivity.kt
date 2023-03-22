package com.eneskkoc.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eneskkoc.jetpack.ui.theme.JetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MyApp()
                    ColumnDe()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(16.dp), color = MaterialTheme.colors.error)
}

@Composable
private fun ColumnDe() {//column example
    Surface(color = MaterialTheme.colors.secondary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
            Text(text = "Hello")
            Text(text = "Android")
        }
    }
}
@Composable
private fun SimpleButton(name: String){
    Surface(color = MaterialTheme.colors.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello")
                Text(text = name)
            }
            //button add ve color
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)) {
                Text(text = "Show More")
            }
            /*
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Show More")
            }

             */

        }

    }
}
@Composable
fun MyAppFor(names: List<String> = listOf("World", "Compose")) {//for and list example
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            SimpleButton(name = name)
        }
    }
}
@Composable
private fun MyApp() {
    Surface(color = MaterialTheme.colors.primary) {
        Greeting(name = "Android")
    }
}

@Composable
private fun Greetings(names: List<String> = List(40) { "$it" } ) {//list example
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            SimpleButton(name = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackTheme {
        //MyApp()
       // ColumnDe()
       // MyAppFor()
        Greetings()
    }
}