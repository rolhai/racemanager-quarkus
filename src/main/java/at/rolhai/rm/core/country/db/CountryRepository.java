package at.rolhai.rm.core.country.db;

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
