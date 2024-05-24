package at.htl.carshop.model;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import javax.inject.Inject;

import at.htl.carshop.util.store.Store;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class ModelStore extends Store<Model> {
    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setCars(Car[] cars) {
        apply(model -> model.cars = cars);
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
    }

    @NotNull
    public void createCar(@NotNull Car car) {
        apply(model -> {
            Car[] carsAll = model.cars;
            Car[] cars = new Car[carsAll.length + 1];
            car.id = (long) cars.length;
            System.arraycopy(carsAll, 0, cars, 0, carsAll.length);
            cars[carsAll.length] = car;
            model.cars = cars;
            Log.i("ModelStore", "Created car: " + car);
        });
    }

    public void createRepair(@NotNull Repair repair) {
        apply(model -> {
            Repair[] repairsAll = model.repairs;
            Repair[] repairs = new Repair[repairsAll.length + 1];
            repair.id = (long) repairs.length;
            System.arraycopy(repairsAll, 0, repairs, 0, repairsAll.length);
            repairs[repairsAll.length] = repair;
            model.repairs = repairs;
            Log.i("ModelStore", "Created repair: " + repair);
        });
    }
}
