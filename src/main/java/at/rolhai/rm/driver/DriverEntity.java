package at.rolhai.rm.driver;

import java.time.LocalDate;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * A race driver of a team
 */
@MongoEntity(collection="Driver")
public class DriverEntity extends PanacheMongoEntity {

    /**
     * personel number of the driver
     * 
     * @see https://en.wikipedia.org/wiki/List_of_Formula_One_driver_numbers
     * 
     * example: 33
     */
    public Long number;

    /**
     * first name of the driver
     * 
     * example: Max
     */
    public String firstname;
    
    /**
     * last name of the driver
     * 
     * example: Verstappen
     */
    public String lastname;

    /**
     * day of birth
     */
    public LocalDate birthday;

    /**
     * nationality of the driver
     * 
     * mapped to CountryEntity.id
     */
    public ObjectId countryId;

    /**
     * website of the driver
     * 
     * example: https://de.wikipedia.org/wiki/Max_Verstappen
     */
    public String website;

    public boolean player;
}
