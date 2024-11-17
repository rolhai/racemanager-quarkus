package at.rolhai.rm.country.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * country of a driver, team or track.<br>
 *
 * country codes defined by the 'International Olympic Committee' (IOC) are used.<br>
 *
 * <a href="https://de.wikipedia.org/wiki/Liste_der_IOC-L%C3%A4ndercodes">see list of IOC countries</a><br>
 *
 * <a href="https://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste">see list of ISO countries</a>
 */
@Getter
@Setter
@ToString
@Entity(name="race_countries")
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * IOC code - alpha-3
     * <p>
     * example: AUT
     */
    private String iocCode;

     /**
     * name of the country
     * <p>
     * example: Österreich
     */
     private String name;

    /**
     * website
     * <p>
     * example: https://de.wikipedia.org/wiki/%C3%96sterreich
     */
    private String website;
}
