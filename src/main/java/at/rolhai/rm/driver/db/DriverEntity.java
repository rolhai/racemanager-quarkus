package at.rolhai.rm.driver.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

/**
 * A race driver of a team
 */
@Entity(name="race_drivers")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * personal number of the driver
     *
     * <a href="https://en.wikipedia.org/wiki/List_of_Formula_One_driver_numbers">see list of drivers</a>
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
    public String countryCode;

    /**
     * website of the driver
     * 
     * example: https://de.wikipedia.org/wiki/Max_Verstappen
     */
    public String website;

    public boolean player;
}
