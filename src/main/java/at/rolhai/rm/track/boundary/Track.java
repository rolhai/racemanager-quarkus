package at.rolhai.rm.track.boundary;

import at.rolhai.rm.country.boundary.Country;

/**
 * A race track
 */
public class Track {

    /**
     * unique identification number
     */
    private Long id;

    /**
     * name ot the track
     * 
     * example: Hockenheimring
     */
    private String name;

    /**
     * number of turn
     * 
     * example: 17
     */
    private Long turns;

    /**
     * length of a turn in km
     * 
     * example: 4574
     */
    private Long length;

    /**
     * location of the track
     * 
     * example: Am Motodrom, Hockenheim
     */
    private String location;

    /**
     * country where the track is located
     * 
     * example: DE
     */
    private Country nation;

    /**
     * website of the track
     * 
     * example: https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg
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
        Track other = (Track) obj;
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

    public long getTurns() {
        return turns;
    }

    public void setTurns(long turns) {
        this.turns = turns;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
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
