package at.htlleonding.carShop.control;

import at.htlleonding.carShop.entity.Repair;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepairRepository implements PanacheRepository<Repair> {
}
