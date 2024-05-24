package at.htl.carshop.model;

import android.util.Log;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.carshop.DTO.RepairDTO;
import at.htl.carshop.util.resteasy.RestApiClientBuilder;

@Singleton
public class RepairService {
    static final String TAG = CarService.class.getSimpleName();
    public static String JSON_PLACEHOLDER_BASE_URL = "http://10.0.2.2:8080";
    public final RepairClient repairClient;

    @Inject
    RepairService(RestApiClientBuilder builder) {
        Log.i(TAG, "Creating CarService with base url: " + JSON_PLACEHOLDER_BASE_URL);
        repairClient = builder.build(RepairClient.class, JSON_PLACEHOLDER_BASE_URL);
    }


    public CompletableFuture<Repair[]> getAll() {
        return CompletableFuture
                .supplyAsync(() -> {
                    Repair[] repairs = repairClient.all();
                    Log.i(TAG, "Repair: Total repairs loaded: " + repairs.length);
                    for (Repair repair : repairs) {
                        Log.i(TAG, "Repair: Description: " + repair.description);
                        Log.i(TAG, "Repair: Price: " + repair.price);
                        Log.i(TAG, "Repair: Car ID: " + repair.carId);
                    }
                    return repairs;
                })
                .exceptionally((e) -> {
                    Log.e(TAG, "Error loading repairs", e);
                    return null;
                });
    }

    public void delete(Long id) {
        CompletableFuture.runAsync(() -> {
            repairClient.delete(id);
            Log.i(TAG, "Repair: Deleted repair with id: " + id);
        }).exceptionally((e) -> {
            Log.e(TAG, "Error deleting repair with id: " + id, e);
            return null;
        });
    }

    public void save(Repair repair) {
        CompletableFuture.runAsync(() -> {
            RepairDTO repairDTO = new RepairDTO(repair.carId, repair.description, repair.price);
            repairClient.add(repairDTO);
            Log.i(TAG, "Repair: Saved repair with id: " + repair.id);
        }).exceptionally((e) -> {
            Log.e(TAG, "Error saving repair with id: " + repair.id, e);
            return null;
        });
    }
}
