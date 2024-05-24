package at.htl.carshop.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
class CreateRepairView @Inject constructor() {
}

@Composable
fun CreateRepair(model: Model, store: ModelStore) {
    var price by remember { mutableStateOf("") }
    var car by remember { mutableStateOf(Car()) }
    var description by remember { mutableStateOf("") }
    var showDropdown by remember { mutableStateOf(false) }

    Row {
        Button(onClick = { showDropdown = true }) {
            Text("Select Car")
        }
        DropdownMenu(
            expanded = showDropdown,
            onDismissRequest = { showDropdown = false }
        ) {
            if (model.cars.isNotEmpty()) {
                model.cars.forEach { dropdownCar ->
                    DropdownMenuItem(onClick = {
                        car = dropdownCar
                        showDropdown = false
                    }, text = {
                        Text(text = dropdownCar.brand + " " + dropdownCar.model)
                    })
                }
            }
        }
    }
    Row {
        Text(text = "Selected Car: " + car.brand + " " + car.model)
    }
    Row {
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        TextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") }
        )
        Spacer(modifier = Modifier.height(20.dp))
    }
    Row {
        IconButton(onClick = {
            val repair = Repair(car, 1, description, price.toInt())
            store.createRepair(repair)
        }) {
            Icon(Icons.Filled.Add, "Create Car")
        }
    }
}