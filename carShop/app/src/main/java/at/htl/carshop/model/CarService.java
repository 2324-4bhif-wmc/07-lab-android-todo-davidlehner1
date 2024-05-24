package at.htl.carshop.model;

import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.carshop.DTO.CarDTO;
import at.htl.carshop.util.resteasy.RestApiClientBuilder;

@Singleton
public class CarService {
    static final String TAG = CarService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "http://10.0.2.2:8080";
    public final CarClient carClient;

    @Inject
    CarService(RestApiClientBuilder builder) {
        Log.i(TAG, "Creating CarService with base url: " + JSON_PLACEHOLDER_BASE_URL);
        carClient = builder.build(CarClient.class, JSON_PLACEHOLDER_BASE_URL);
    }


    public CompletableFuture<Car[]> getAll() {
        return CompletableFuture
                .supplyAsync(() -> {
                    Car[] cars = carClient.all();
                    Log.i(TAG, "Car: Total cars loaded: " + cars.length);
                    for (Car car : cars) {
                        Log.i(TAG, "Car: Brand: " + car.brand);
                        Log.i(TAG, "Car: Model: " + car.model);
                    }
                    return cars;
                })
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading cars", e);
                    return null;
                });
    }

    public void delete(Long id) {
        CompletableFuture.runAsync(() -> {
            carClient.delete(id);
            Log.i(TAG, "Car: Deleted car with id: " + id);
        }).exceptionally((e) -> {
            Log.e(TAG, "Error deleting car with id: " + id, e);
            return null;
        });
    }

    public void save(Car car) {
        CompletableFuture.runAsync(() -> {
            CarDTO carDTO = new CarDTO(car.brand, car.model, car.year, car.color, car.price);
            carClient.add(carDTO);
            Log.i(TAG, "Car: Saved car with id: " + car.id);
        }).exceptionally((e) -> {
            Log.e(TAG, "Error saving car with id: " + car.id, e);
            return null;
        });
    }
}
