package at.rolhai.rm.company;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheMongoRepository<CompanyEntity> {
    
}
