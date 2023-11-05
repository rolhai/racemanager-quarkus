package at.rolhai.rm.driver.boundary;

import java.time.ZonedDateTime;

import at.rolhai.rm.country.boundary.Country;

/**
 * A race driver of a team
 */
public class Driver {

    /**
     * unique identification number
     */
    private Long id;

    /**
     * personel number of the driver
     * 
     * @see https://en.wikipedia.org/wiki/List_of_Formula_One_driver_numbers
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
    private ZonedDateTime birthday;

    /**
     * nationality of the driver
     */
    private Country nationality;

    /**
     * website of the driver
     * 
     * example: https://de.wikipedia.org/wiki/Max_Verstappen
     */
    private String website;

    private boolean player;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
        result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
        Driver other = (Driver) obj;
        if (firstname == null) {
            if (other.firstname != null)
                return false;
        } else if (!firstname.equals(other.firstname))
            return false;
        if (lastname == null) {
            if (other.lastname != null)
                return false;
        } else if (!lastname.equals(other.lastname))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    } 
}
