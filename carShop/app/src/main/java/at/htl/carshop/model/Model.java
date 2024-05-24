package at.htl.carshop.model;

public class Model {
    public static class UIState {
        public int selectedTab = 0;
    }

    public Car[] cars = {
            new Car(1L, "Audi", "A4", 2018, "black", 30000),
            new Car(2L, "BMW", "X5", 2019, "white", 50000),
            new Car(3L, "Mercedes", "C-Class", 2017, "silver", 35000),
    };

    public Repair[] repairs = {
            new Repair(cars[0], 1L, "Change oil", 100),
            new Repair(cars[0], 2L, "Change tires", 200),
            new Repair(cars[1], 3L, "Change oil", 100),
            new Repair(cars[1], 4L, "Change tires", 200),
            new Repair(cars[2], 5L, "Change oil", 100),
            new Repair(cars[2], 6L, "Change tires", 200),
    };
    public UIState uiState = new UIState();

}

