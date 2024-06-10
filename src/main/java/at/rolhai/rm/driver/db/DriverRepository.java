package at.rolhai.rm.driver.db;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverRepository implements PanacheRepository<DriverEntity> {

    public DriverEntity findByDriverName(String firstname, String lastname) {
        return find("firstname = :firstname and lastname = :lastname", 
            Parameters
            .with("firstname", firstname)
            .and("lastname", lastname))
            .singleResult();
    }
    
}
