package at.rolhai.rm.driver.control;

import at.rolhai.rm.driver.entity.DriverEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverRepository implements PanacheRepository<DriverEntity> {

    public DriverEntity findByName(String firstname, String lastname) {
        return find("firstname = :firstname and lastname = :lastname", 
                    Parameters.with("firstname", firstname).and("lastname", lastname))
                    .firstResult();
    }
    
}
