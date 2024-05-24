package at.htl.carshop.DTO;

public class RepairDTO {
    public Long carId;
    public String description;
    public int price;

    public RepairDTO() {
    }

    public RepairDTO(Long carId, String description, int price) {
        this.carId = carId;
        this.description = description;
        this.price = price;
    }
}
