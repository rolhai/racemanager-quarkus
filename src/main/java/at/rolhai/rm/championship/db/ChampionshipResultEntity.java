package at.rolhai.rm.championship.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.event.db.EventEntity;
import at.rolhai.rm.core.team.db.TeamEntity;
import at.rolhai.rm.core.season.db.SeasonEntity;
import io.smallrye.common.constraint.NotNull;
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
@Entity(name="championship_results")
public class ChampionshipResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "championshipId", foreignKey=@ForeignKey(name="fk_championship_results_championshipId"), nullable = false)
    private ChampionshipEntity championship;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "eventId", foreignKey=@ForeignKey(name="fk_championship_results_eventId"), nullable = false)
    private EventEntity event;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "teamId", foreignKey=@ForeignKey(name="fk_championship_results_teamId"), nullable = false)
    private TeamEntity team;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "driverId", foreignKey=@ForeignKey(name="fk_championship_results_driverId"), nullable = false)
    private DriverEntity driver;

    /**
     * Date when the event happened
     * 
     * example: 01.06.2021
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate eventDate;

    /**
     * Type of event
     *
     * example: 'R' ... race
     */
    private String eventType;

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
