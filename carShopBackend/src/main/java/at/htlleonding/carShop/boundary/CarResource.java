package at.htlleonding.carShop.boundary;

import at.htlleonding.carShop.control.CarRepository;
import at.htlleonding.carShop.entity.Car;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "car")
public interface CarResource extends PanacheRepositoryResource<CarRepository, Car, Long> {
}
