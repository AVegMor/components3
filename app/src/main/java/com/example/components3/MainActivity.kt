package com.example.components3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.components3.ui.theme.Components3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Components3Theme {
                SimpleList()
            }
        }
    }
}

@Composable
fun SimpleList() {
    val lista = MutableList(50) { index -> "Element $index" }
    LazyColumn(modifier = Modifier.padding(15.dp)) {
        item { Text(text = "Primer item") }
        items(lista) {
            Text(text = "Soy $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Components3Theme {
        SimpleList()
    }
}
