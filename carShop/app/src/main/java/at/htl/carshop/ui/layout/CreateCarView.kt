package at.htl.carshop.ui.layout

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import at.htl.carshop.model.Model
import at.htl.carshop.model.ModelStore
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CreateCarView @Inject constructor(){
}

@Composable
fun CreateCar(model: Model, store: ModelStore){
    Surface {
        Text(text = "Create Car View")
    }
}