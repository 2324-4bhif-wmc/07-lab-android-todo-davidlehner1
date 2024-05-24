package at.htl.carshop.model;

import javax.inject.Inject;

import at.htl.carshop.util.store.Store;

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

    // Remove car
    public void delete(int index){
        apply(model -> {
            Car[] carsAll = model.cars;
            Car[] cars = new Car[carsAll.length - 1];
            System.arraycopy(carsAll, 0, cars, 0, index);
            System.arraycopy(carsAll, index + 1, cars, index, carsAll.length - index - 1);
            model.cars = cars;
        });
    }

    // Remove Repair
    public void deleteRepair(int index){
        apply(model -> {
            Repair[] repairsAll = model.repairs;
            Repair[] repairs = new Repair[repairsAll.length - 1];
            System.arraycopy(repairsAll, 0, repairs, 0, index);
            System.arraycopy(repairsAll, index + 1, repairs, index, repairsAll.length - index - 1);
            model.repairs = repairs;
        });
    }
}
