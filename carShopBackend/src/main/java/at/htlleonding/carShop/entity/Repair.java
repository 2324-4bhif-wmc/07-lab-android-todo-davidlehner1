package at.htlleonding.carShop.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Repair extends PanacheEntity {

    Long carId;
    public String description;
    public int price;

    public Repair() {
    }

    public Repair(Long carId, String description, int price) {
        this.carId = carId;
        this.description = description;
        this.price = price;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCar(Long carId) {
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
