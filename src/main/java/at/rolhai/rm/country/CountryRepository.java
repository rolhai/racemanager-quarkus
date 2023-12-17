package at.rolhai.rm.country;

import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheMongoRepository<CountryEntity> {

    public List<CountryEntity> findByFilter(String iocCode) {
        return find("iocCode = :iocCode",
                Parameters.with("iocCode", iocCode))
                .list();
    }
    
}
