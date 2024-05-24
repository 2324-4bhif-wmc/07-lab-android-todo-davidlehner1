package at.htl.carshop.model;

public class Repair {
    public Car car;
    public Long id;
    public String description;
    public int price;

    public Repair() {
    }

    public Repair(Car car, Long id, String description, int price) {
        this.car = car;
        this.id = id;
        this.description = description;
        this.price = price;
    }
}
