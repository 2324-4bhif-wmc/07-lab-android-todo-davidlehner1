package at.htl.carshop.ui.layout

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import at.htl.carshop.model.Model
import at.htl.carshop.model.ModelStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarView  @Inject constructor() {
}

@Composable
fun Cars(model: Model, store: ModelStore, modifier: Modifier){
    Surface {

    }
    FloatingActionButton(
        onClick = { /*TODO*/ },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }

}