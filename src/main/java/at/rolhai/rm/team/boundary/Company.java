package at.rolhai.rm.team.boundary;

import at.rolhai.rm.country.boundary.Country;

/**
 * The company managing a team
 */
public class Company {

    /**
     * unique identification number
     */
    private Long id;

    /**
     * name of the company
     * 
     * example: Red Bull Racing
     */
    private String name;

    /**
     * location of the home base
     * 
     * example: Milton Keynes 
     */
    private String location;

    /**
     * country of the home base
     * 
     * example: GB
     */
    private Country nation;

    /**
     * website
     * 
     * example: https://de.wikipedia.org/wiki/Red_Bull_Racing
     */
    private String website;

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
        Company other = (Company) obj;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Country getNation() {
        return nation;
    }

    public void setNation(Country nation) {
        this.nation = nation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
