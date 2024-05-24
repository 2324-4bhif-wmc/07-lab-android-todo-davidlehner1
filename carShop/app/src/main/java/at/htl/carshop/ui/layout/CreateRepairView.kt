package at.htl.carshop.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.carshop.model.Car
import at.htl.carshop.model.Model
import at.htl.carshop.model.ModelStore
import at.htl.carshop.model.Repair
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateRepairView @Inject constructor(){
}

@Composable
fun CreateRepair(model: Model, store: ModelStore){
    var price by remember { mutableStateOf("") }
    var car by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

/*    Row {
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Brand") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        TextField(
            value = model,
            onValueChange = { model = it },
            label = { Text("Model") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        TextField(
            value = year,
            onValueChange = { year = it },
            label = { Text("Year") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        TextField(
            value = color,
            onValueChange = { color = it },
            label = { Text("Color") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        TextField(
            value = price,
            onValueChange = { price = it},
            label = { Text("Price") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        IconButton(onClick = {
            val car = Car(1, brand, model, year.toInt(), color, price.toInt())
            store.createCar(car)
        }) {
            Icon(Icons.Filled.Add, "Create Car")
        }
    }*/
}