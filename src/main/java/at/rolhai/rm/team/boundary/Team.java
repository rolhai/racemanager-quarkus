package at.rolhai.rm.team.boundary;

import java.util.Map;

import at.rolhai.rm.country.boundary.Country;
import at.rolhai.rm.driver.boundary.Driver;

/**
 * A racing team
 */
public class Team {

    /**
     * unique identification number
     */
    private Long id;
    
    /**
     * name of the team
     * 
     * example: Red Bull
     */
    private String name;

    /**
     * home base of the team
     * 
     * example: Milton Keynes, GB
     */
    private Company base;

    /**
     * name of the car chassis
     * 
     * example: RB19
     */
    private String chassis;

    /**
     * engine of the race car
     * 
     * example: Honda RBPT
     */
    private String engine;

    /**
     * the teams drives with the license from this country
     * 
     * example: AT
     */
    private Country license;

    /**
     * list of drivers with the position in the team
     * 
     * example: 1 - Max Verstappen
     */
    private Map<Long, Driver> drivers;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Team other = (Team) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getBase() {
        return base;
    }

    public void setBase(Company base) {
        this.base = base;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Country getLicense() {
        return license;
    }

    public void setLicense(Country license) {
        this.license = license;
    }

    public Map<Long, Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Map<Long, Driver> drivers) {
        this.drivers = drivers;
    }
    
}
