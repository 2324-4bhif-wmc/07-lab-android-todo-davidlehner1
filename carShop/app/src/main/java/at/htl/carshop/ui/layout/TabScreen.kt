package at.htl.carshop.ui.layout

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import at.htl.carshop.model.Model
import at.htl.carshop.model.ModelStore
import at.htl.carshop.ui.layout.Cars

@Composable
fun TabScreen(model: Model, store: ModelStore?, activity: ComponentActivity) {
    var uiState = model.uiState
    val tabIndex = uiState.selectedTab
    val tabs = listOf("Cars", "Repairs")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = uiState.selectedTab) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { store?.selectTab(index) },
                    icon = {
                        when (index) {
                            0 -> Icon(imageVector = Icons.Default.Home, contentDescription = null)
                            1 -> BadgedBox(badge = { Badge { Text("${model.repairs.size}") } }) {
                                Icon(Icons.Filled.Settings, contentDescription = "Repairs")
                            }
                        }
                    }
                )
            }
        }
        when (tabIndex) {
            0 -> store?.let {
                Cars(
                    model = model,
                    modifier = Modifier.padding(top = 56.dp),
                    store = it
                )
            }

            1 -> store?.let { CarsRepair(model = model, store = it) }
            2 -> {
                store?.let { CreateCar(model = model, store = it) }
            }

            3 -> {
                store?.let { CreateRepair(model = model, store = it) }
            }
        }
    }
}

