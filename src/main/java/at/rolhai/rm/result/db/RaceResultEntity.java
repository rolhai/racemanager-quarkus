package at.rolhai.rm.result.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbTransient;
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

    @JsonbTransient
    public Integer bestTimeMinutes;

    @JsonbTransient
    public Integer bestTimeSeconds;

    @JsonbTransient
    public Integer bestTimeMilliseconds;

    /**
     * Best time of the driver for this event
     *
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

    @Override
    public String toString() {
        return "RaceResultEntity{" +
                "id=" + id +
                ", seasonId=" + seasonId +
                ", eventDate=" + eventDate +
                ", trackName='" + trackName + '\'' +
                ", eventType='" + eventType + '\'' +
                ", driverFirstname='" + driverFirstname + '\'' +
                ", driverLastname='" + driverLastname + '\'' +
                ", teamName='" + teamName + '\'' +
                ", ranking=" + ranking +
                ", bestTimeMinutes=" + bestTimeMinutes +
                ", bestTimeSeconds=" + bestTimeSeconds +
                ", bestTimeMilliseconds=" + bestTimeMilliseconds +
                '}';
    }
}
