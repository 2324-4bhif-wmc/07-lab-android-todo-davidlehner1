package at.htl.carshop.model;

public class Model {
    public static class UIState {
        public int selectedTab = 0;
    }

    public Car[] cars = new Car[0];

    public Repair[] repairs = new Repair[0];
    public UIState uiState = new UIState();

}

