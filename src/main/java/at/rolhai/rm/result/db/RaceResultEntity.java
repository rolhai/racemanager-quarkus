package at.rolhai.rm.result.db;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity(name="race_results")
public class RaceResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * ID of the season
     */
    public Long seasonId;

    /**
     * Date when the event happened
     * 
     * example: 01.06.2021
     */
    @Column(columnDefinition = "DATE")
    public LocalDate eventDate;

    /**
     * name of the track
     *
     * example: Hockenheimring
     */
    public String trackName;

    /**
     * Type of event
     *
     * example: 'R' ... race
     */
    public String eventType;

    /**
     * first name of the driver
     *
     * example: Max
     */
    public String driverFirstname;

    /**
     * last name of the driver
     *
     * example: Verstappen
     */
    public String driverLastname;

    /**
     * ranking for the event
     * 
     * example: 1 ... first place
     */
    public Integer ranking;

    /**
     * Best time of the driver for this event
     * 
     * example: 1:36:24
     */
    @Column(columnDefinition = "TIME")
    public LocalTime bestTime;
    
}
