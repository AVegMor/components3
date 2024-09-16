package com.example.components3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.components3.model.Heroe
import com.example.components3.ui.theme.Components3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Components3Theme {
                RecyclerView2()

            }
        }
    }
}

fun getHeroes(): List<Heroe> {
    return listOf(
        Heroe(
            "Spiderman",
            realName = "Peter Parker",
            publisher = "Marvel",
            photo = R.drawable.spiderman
        ),
        Heroe(
            "Wolverine",
            realName = "James Howlett",
            publisher = "Marvel",
            photo = R.drawable.logan
        ),
        Heroe("Batman", realName = "Bruce Wayne", publisher = "DC", photo = R.drawable.batman),
        Heroe(
            "Wonder woman",
            realName = "Princess Diana",
            publisher = "DC",
            photo = R.drawable.wonder_woman
        ),
        Heroe(
            "Thor",
            realName = "Unkown",
            publisher = "Marvel",
            photo = R.drawable.thor
        ),
    )
}

@Composable
fun RecyclerView2() {
    var context = LocalContext.current
    val lista = getHeroes()
    LazyColumn(modifier = Modifier.padding(24.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
        items(lista) {
            ItemHeroe(it){ Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()}
        }
    }
}

@Composable
fun ItemHeroe(heroe: Heroe, onItemSelected: (Heroe) -> Unit) {

    Box(modifier = Modifier.clickable { onItemSelected(heroe) }) {
        Column {
            Image(
                painter = painterResource(id = heroe.photo),
                contentDescription = "Avatar de Héroe",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = heroe.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = heroe.realName, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Text(text = heroe.publisher, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 10.sp)
        }
    }
}

@Composable
fun SimpleRecyclerView() {
    val lista = listOf("mesa", "silla", "pizarra", "teclado", "raton")
    LazyColumn {
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
        SimpleRecyclerView()
    }
}
