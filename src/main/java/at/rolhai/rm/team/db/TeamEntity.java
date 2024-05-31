package at.rolhai.rm.team.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * A racing team
 */
@Entity(name="race_teams")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    /**
     * name of the team
     * 
     * example: Red Bull
     */
    public String name;

    /**
     * engine of the race car
     *
     * example: Honda
     */
    public String engine;

    /**
     * company behind the team
     * 
     * example: Milton Keynes
     */
    public String companyLocation;

    /**
     * the country where the company is located
     *
     * example: GBR
     */
    public String companyCountryCode;

    /**
     * the teams drives with the license from this country
     *
     * example: AUT
     */
    public String licenceCountryCode;

    /**
     * website
     *
     * example: https://de.wikipedia.org/wiki/Red_Bull_Racing
     */
    public String website;
}
