package at.rolhai.rm.country.db;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<CountryEntity> {

    public CountryEntity findByIcoCode(String iocCode) {
        return find("iocCode = :iocCode",
            Parameters
            .with("iocCode", iocCode))
            .singleResult();
    }
    
}
