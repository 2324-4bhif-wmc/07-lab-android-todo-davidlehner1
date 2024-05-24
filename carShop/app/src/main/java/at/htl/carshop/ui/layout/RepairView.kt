package at.htl.carshop.ui.layout

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import at.htl.carshop.model.Car
import at.htl.carshop.model.Model
import at.htl.carshop.model.ModelStore
import at.htl.carshop.model.Repair
import java.lang.reflect.Modifier
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepairView @Inject constructor() {
}

@Composable
fun CarsRepair(model: Model, store: ModelStore) {
    val cars = model.cars
    val expandedMap = remember { mutableStateMapOf<Car, Boolean>() }

    LazyColumn() {
        items(cars.size) { index ->
            val car = cars[index]
            val isExpanded = expandedMap[car] ?: false
            CarRowRepair(car = car, isExpanded = isExpanded, onExpandClicked = {
                expandedMap[car] = !isExpanded
            })
            HorizontalDivider()
            if (isExpanded) {
                val repairs = model.repairs.filter { it.car.id == car.id }
                repairs.forEach { repair ->
                    RepairRow(repair = repair, store = store)
                    HorizontalDivider()
                }
            }
        }
    }
    FloatingActionButton(
        onClick = { store.selectTab(3) },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@Composable
fun CarRowRepair(car: Car, isExpanded: Boolean, onExpandClicked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = androidx.compose.ui.Modifier.padding(8.dp),
    ) {
        Text(
            text = car.brand,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            modifier = androidx.compose.ui.Modifier.weight(3f)
        )
        Text(
            text = car.model,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            modifier = androidx.compose.ui.Modifier.weight(3f)
        )
        Text(
            text = car.year.toString(),
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
        )
        Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))

        IconButton(onClick = onExpandClicked) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                contentDescription = "Expand/Collapse"
            )
        }
    }
}

@Composable
fun RepairRow(repair: Repair, store: ModelStore) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = androidx.compose.ui.Modifier.padding(5.dp)
    ) {
        Text(
            text = repair.description,
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            modifier = androidx.compose.ui.Modifier.weight(3f)
        )
        Text(
            text = repair.price.toString() + "€",
            style = MaterialTheme.typography.bodySmall,
            overflow = TextOverflow.Ellipsis,
            modifier = androidx.compose.ui.Modifier.weight(3f)
        )
        IconButton(onClick = { store.deleteRepairById(repair.id) }){
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete"
            )
        }
    }
}