package at.rolhai.rm.core.team.db;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A racing team
 */
@Getter
@Setter
@ToString
@Entity(name="teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * name of the team
     * <p>
     * example: Red Bull
     */
    @NotNull
    private String name;

    /**
     * engine of the race car
     * <p>
     * example: Honda
     */
    @NotNull
    private String engine;

    /**
     * company behind the team
     * <p>
     * example: Milton Keynes
     */
    private String companyLocation;

    /**
     * the country where the company is located
     * <p>
     * example: GBR
     */
    private String companyCountryCode;

    /**
     * the teams drives with the license from this country
     * <p>
     * example: AUT
     */
    private String licenceCountryCode;

    /**
     * website
     * <p>
     * example: https://de.wikipedia.org/wiki/Red_Bull_Racing
     */
    private String website;
}
