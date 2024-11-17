package at.rolhai.rm.result.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@Entity(name="race_results")
public class RaceResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ID of the season
     */
    private Long seasonId;

    /**
     * Date when the event happened
     * 
     * example: 01.06.2021
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate eventDate;

    /**
     * name of the track
     *
     * example: Hockenheimring
     */
    private String trackName;

    /**
     * Type of event
     *
     * example: 'R' ... race
     */
    private String eventType;

    /**
     * first name of the driver
     *
     * example: Max
     */
    private String driverFirstname;

    /**
     * last name of the driver
     *
     * example: Verstappen
     */
    private String driverLastname;

    /**
     * name of the team
     *
     * example: Red Bull
     */
    private String teamName;

    /**
     * ranking for the event
     * 
     * example: 1 ... first place
     */
    private Integer ranking;

    @JsonbTransient
    private Integer bestTimeMinutes;

    @JsonbTransient
    private Integer bestTimeSeconds;

    @JsonbTransient
    private Integer bestTimeMilliseconds;

    /**
     * Best time of the driver for this event
     * <p>
     * example: 00:01:36.245
     */
    @JsonbDateFormat(value = DateTimeConfiguration.TIME_FORMAT)
    public LocalTime getBestTime() {
        return LocalTime.of(0, bestTimeMinutes, bestTimeSeconds, bestTimeMilliseconds);
    }

    public void setBestTime(LocalTime time) {
        this.bestTimeMinutes = time.getMinute();
        this.bestTimeSeconds = time.getSecond();
        this.bestTimeMilliseconds = time.getNano();
    }
}
