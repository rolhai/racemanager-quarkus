package at.rolhai.rm.driver;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverRepository implements PanacheMongoRepository<DriverEntity> {

    public DriverEntity findByFilter(String firstname, String lastname) {
        return find("firstname = :firstname and lastname = :lastname", 
                    Parameters.with("firstname", firstname).and("lastname", lastname))
                    .firstResult();
    }
    
}
