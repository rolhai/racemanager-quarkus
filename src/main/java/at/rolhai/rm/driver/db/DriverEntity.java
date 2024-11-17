package at.rolhai.rm.driver.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

/**
 * A race driver of a team
 */
@Getter
@Setter
@ToString
@Entity(name="race_drivers")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * personal number of the driver
     *
     * <a href="https://en.wikipedia.org/wiki/List_of_Formula_One_driver_numbers">see list of drivers</a>
     *
     * example: 33
     */
    private Long number;

    /**
     * first name of the driver
     *
     * example: Max
     */
    private String firstname;

    /**
     * last name of the driver
     *
     * example: Verstappen
     */
    private String lastname;

    /**
     * day of birth
     */
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate birthday;

    /**
     * nationality of the driver
     */
    private String countryCode;

    /**
     * website of the driver
     *
     * example: https://de.wikipedia.org/wiki/Max_Verstappen
     */
    private String website;

    private boolean player;
}
