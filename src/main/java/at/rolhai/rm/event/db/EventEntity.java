package at.rolhai.rm.event.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * An event on a race track<br>
 *
 * <a href="https://de.wikipedia.org/wiki/Liste_der_Formel-1-Rennstrecken">see list of tracks</a>
 */
@Entity(name="race_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * ID of the season
     */
    public Long seasonId;

    /**
     * order number of the event in a season
     *
     * example: 1
     */
    public Integer orderNumber;

    /**
     * name of the event
     *
     * example: Grand Prix von Deutschland
     */
    public String eventName;

    /**
     * name ot the track
     * 
     * example: Hockenheimring
     */
    public String trackName;

    /**
     * location of the track
     * 
     * example: Hockenheim
     */
    public String location;

    /**
     * country where the track is located
     * 
     * example: GER
     */
    public String countryCode;

    /**
     * website of the track
     * 
     * example: https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg
     */
    public String website;

}
