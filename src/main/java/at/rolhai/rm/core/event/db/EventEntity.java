package at.rolhai.rm.core.event.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * An event on a race track<br>
 *
 * <a href="https://de.wikipedia.org/wiki/Liste_der_Formel-1-Rennstrecken">see list of tracks</a>
 */
@Getter
@Setter
@ToString
@Entity(name="events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name of the event
     *
     * example: Grad Prix von Deutschland
     */
    private String eventName;

    /**
     * name ot the track
     * 
     * example: Hockenheimring
     */
    private String trackName;

    /**
     * location of the track
     * 
     * example: Hockenheim
     */
    private String location;

    /**
     * country where the track is located
     * 
     * example: GER
     */
    private String countryCode;

    /**
     * website of the track
     * 
     * example: https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg
     */
    private String website;

}
