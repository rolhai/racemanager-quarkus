package at.rolhai.rm.country.boundary;

/**
 * country of a driver, team or track.
 * 
 * country codes defined by the 'International Olympic Committee' (IOC) are used.
 * 
 * @see https://de.wikipedia.org/wiki/Liste_der_IOC-L%C3%A4ndercodes
 * @see https://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste
 */
public class Country {

    /**
     * unique identification number
     */
    private Long id;

    /**
     * IOC alpha-3 iso code
     * 
     * example: AUT
     */
    private String code;
    
    /**
     * name of the country
     * 
     * example: Österreich
     */
    private String name;

    /**
     * website
     * 
     * example: https://de.wikipedia.org/wiki/%C3%96sterreich
     */
    private String website;

     @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        Country other = (Country) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }    
}
