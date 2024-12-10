package es.crisvega.actrecyclerview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun LazyColumnTareas(modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(getTareas()) {
            itemTarea(it)
        }
    }
}

@Composable
fun itemTarea(model: Model) {
    var realizado = rememberSaveable {mutableStateOf(model.realizado)}

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = model.nombreTarea, modifier = Modifier.padding(15.dp))
            Text(
                text = model.descripcionTarea,
                fontSize = 10.sp,
                modifier = Modifier.padding(15.dp)
            )
            Icon(modifier = Modifier.padding(15.dp),
                imageVector = if (realizado.value) {
                    Icons.Default.Check
                } else {
                    Icons.Default.Close
                }, contentDescription = ""
            )
            Button(
                onClick = {
                    realizado.value = !realizado.value
                }
            ){
            }
        }
    }
}

fun getTareas(): List<Model> {
    return listOf(
        Model("Limpiar", "Limpiar la casa", false),
        Model("Lavar", "Lavar la ropa", false),
        Model("Cocinar", "Cocinar la cena", true),
        Model("Pasear", "Pasear al perro", false),
        Model("Leer", "Leer un libro", true),
        Model("Jugar", "Jugar al Fútbol", false)
    )
}