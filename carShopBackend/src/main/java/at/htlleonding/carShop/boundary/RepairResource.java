package at.htlleonding.carShop.boundary;

import at.htlleonding.carShop.control.RepairRepository;
import at.htlleonding.carShop.entity.Repair;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "repair")
public interface RepairResource extends PanacheRepositoryResource<RepairRepository, Repair, Long> {
}
