package at.rolhai.rm.season.db;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name="race_seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    /**
     * The beginning of the season
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate startDate;

    /**
     * End of the season
     */
    @Column(columnDefinition = "DATE")
    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate endDate;

    /**
     * year of the season
     * 
     * example: 2023
     */
    public Integer seasonYear;

    /**
     * racing league
     * 
     * example: Formel 1
     */
    public String league;

    /**
     * name of the season
     * 
     * example: Weltmeisterschaft
     */
    public String seasonName;

    /**
     * name of the race simulation.
     * if empty it is a real world season.
     * 
     * example: F1 23
     */
    public String simulation;
}
