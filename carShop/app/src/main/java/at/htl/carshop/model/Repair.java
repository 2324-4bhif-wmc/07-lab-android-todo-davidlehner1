package at.htl.carshop.model;

public class Repair {
    public Long carId;
    public Long id;
    public String description;
    public int price;

    public Repair() {
    }

    public Repair(Long carId, Long id, String description, int price) {
        this.carId = carId;
        this.id = id;
        this.description = description;
        this.price = price;
    }
}
