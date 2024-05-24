package at.htl.carshop.model;

public class Car {
    public Long id;
    public String brand;
    public String model;
    public int year;
    public String color;
    public int price;

    public Car() {
    }

    public Car(Long id, String brand, String model, int year, String color, int price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }
}
