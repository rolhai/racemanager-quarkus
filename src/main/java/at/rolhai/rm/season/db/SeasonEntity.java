package at.rolhai.rm.season.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity(name="race_seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The beginning of the season
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate startDate;

    /**
     * End of the season
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate endDate;

    /**
     * year of the season
     * <p>
     * example: 2023
     */
    private Integer seasonYear;

    /**
     * racing league
     * <p>
     * example: Formel 1
     */
    private String league;

    /**
     * name of the season
     * <p>
     * example: Weltmeisterschaft
     */
    private String seasonName;

    /**
     * name of the race simulation.
     * if empty it is a real world season.
     * <p>
     * example: F1 23
     */
    private String simulation;
}
