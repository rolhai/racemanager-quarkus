package at.rolhai.rm.country.control;

import at.rolhai.rm.country.entity.CountryEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<CountryEntity> {

    public CountryEntity findByCode(String code) {
        return find("code", code).firstResult();
    }
    
}
