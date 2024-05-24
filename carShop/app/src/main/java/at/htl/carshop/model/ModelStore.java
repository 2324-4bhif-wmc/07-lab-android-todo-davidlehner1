package at.htl.carshop.model;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Singleton;

import at.htl.carshop.util.store.Store;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Singleton
public class ModelStore extends Store<Model> {
    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    @Inject
    CarService carService;

    @Inject
    RepairService repairService;

    public void setCars(Car[] cars) {
        apply(model -> {
            model.cars = cars;
        });
    }

    public void setRepairs(Repair[] repairs) {
        apply(model -> {
            model.repairs = repairs;
        });
    }

    public void selectTab(int tabIndex) {
        apply(model -> model.uiState.selectedTab = tabIndex);
    }

    // Remove car By Id, and also remove associated repairs
    public void deleteCarById(Long id){
        apply(model -> {
            Car[] carsAll = model.cars;
            Car[] cars = new Car[carsAll.length - 1];
            int j = 0;
            for (Car car : carsAll) {
                if (!Objects.equals(car.id, id)) {
                    cars[j] = car;
                    j++;
                }
            }
            model.cars = cars;
        });
        carService.delete(id);
    }

    // Remove Repair By Id
    public void deleteRepairById(Long id){
        apply(model -> {
            Repair[] repairsAll = model.repairs;
            Repair[] repairs = new Repair[repairsAll.length - 1];
            int j = 0;
            for (Repair repair : repairsAll) {
                if (!Objects.equals(repair.id, id)) {
                    repairs[j] = repair;
                    j++;
                }
            }
            model.repairs = repairs;
        });
        repairService.delete(id);
    }

    @NotNull
    public void createCar(@NotNull Car car) {
        apply(model -> {
            Car[] carsAll = model.cars;
            Car[] cars = new Car[carsAll.length + 1];
            long maxId = Arrays.stream(carsAll).mapToLong(c -> c.id).max().orElse(0);
            car.id = maxId + 1;
            System.arraycopy(carsAll, 0, cars, 0, carsAll.length);
            cars[carsAll.length] = car;
            model.cars = cars;
            Log.i("ModelStore", "Created car: " + car);
        });
        carService.save(car);
    }

    public void createRepair(@NotNull Repair repair) {
        apply(model -> {
            Repair[] repairsAll = model.repairs;
            Repair[] repairs = new Repair[repairsAll.length + 1];
            long maxId = Arrays.stream(repairsAll).mapToLong(r -> r.id).max().orElse(0);
            repair.id = maxId + 1;
            System.arraycopy(repairsAll, 0, repairs, 0, repairsAll.length);
            repairs[repairsAll.length] = repair;
            model.repairs = repairs;
            Log.i("ModelStore", "Created repair: " + repair);
        });
        repairService.save(repair);
    }
}
