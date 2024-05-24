package at.htl.carshop.model;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

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

    // Remove car By Id
    public void deleteCarById(Long id){
        apply(model -> {
            Car[] carsAll = model.cars;
            Car[] cars = new Car[carsAll.length - 1];
            int j = 0;
            for (int i = 0; i < carsAll.length; i++) {
                if (carsAll[i].id != id) {
                    cars[j] = carsAll[i];
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
            for (int i = 0; i < repairsAll.length; i++) {
                if (repairsAll[i].id != id) {
                    repairs[j] = repairsAll[i];
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
}
