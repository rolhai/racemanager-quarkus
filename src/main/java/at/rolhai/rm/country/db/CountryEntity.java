package at.rolhai.rm.country.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * country of a driver, team or track.<br>
 *
 * country codes defined by the 'International Olympic Committee' (IOC) are used.<br>
 *
 * <a href="https://de.wikipedia.org/wiki/Liste_der_IOC-L%C3%A4ndercodes">see list of IOC countries</a><br>
 *
 * <a href="https://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste">see list of ISO countries</a>
 */
@Entity(name="race_countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * IOC code - alpha-3
     * 
     * example: AUT
     */
    public String iocCode;

     /**
     * name of the country
     * 
     * example: Österreich
     */
    public String name;

    /**
     * website
     * 
     * example: https://de.wikipedia.org/wiki/%C3%96sterreich
     */
    public String website;
}
