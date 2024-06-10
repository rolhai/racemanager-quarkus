package at.rolhai.rm.result.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
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
     * name of the team
     *
     * example: Red Bull
     */
    public String teamName;

    /**
     * ranking for the event
     * 
     * example: 1 ... first place
     */
    public Integer ranking;

    /**
     * Best time of the driver for this event
     * 
     * example: 00:01:36.245
     */
    @Column(columnDefinition = "TIME")
    @JsonbDateFormat(value = DateTimeConfiguration.TIME_FORMAT)
    public LocalTime bestTime;
    
}
