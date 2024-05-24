package at.htl.carshop.DTO;

public class CarDTO{
    public String brand;
    public String model;
    public int year;
    public String color;
    public int price;

    public CarDTO() {
    }

    public CarDTO(String brand, String model, int year, String color, int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }
}
