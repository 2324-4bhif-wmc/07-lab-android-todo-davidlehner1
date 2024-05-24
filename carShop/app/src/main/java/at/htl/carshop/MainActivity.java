package at.htl.carshop;

import static at.htl.carshop.CarShopApplication.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.ComponentActivity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import at.htl.carshop.model.Car;
import at.htl.carshop.model.CarService;
import at.htl.carshop.model.ModelStore;
import at.htl.carshop.model.Repair;
import at.htl.carshop.model.RepairService;
import at.htl.carshop.ui.layout.MainViewBuilder;
import at.htl.carshop.util.Config;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends ComponentActivity {
    @Inject
    MainViewBuilder mainViewBuilder;
    @Inject
    CarService carService;
    @Inject
    RepairService repairService;

    @Inject
    ModelStore store;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Config.load(this);
        var base_url = Config.getProperty("json.placeholder.baseurl");
        Log.i(TAG, "onCreate: " + base_url);


        CompletableFuture<Car[]> carFuture = carService.getAll()
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading cars", e);
                    return null;
                });

        CompletableFuture<Repair[]> repairFuture = repairService.getAll()
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading repairs", e);
                    return null;
                });

        CompletableFuture.allOf(carFuture, repairFuture).thenRun(() -> {
            Car[] cars = carFuture.join();
            Repair[] repairs = repairFuture.join();

            if (cars != null && repairs != null) {
                store.setCars(cars);
                store.setRepairs(repairs);
                runOnUiThread(() -> {
                    mainViewBuilder.setContentOfActivity(this);
                });
            } else {
                Log.e(TAG, "Error loading cars or repairs");
            }
        });
    }
}
