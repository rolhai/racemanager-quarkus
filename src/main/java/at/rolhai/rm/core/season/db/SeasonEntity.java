package at.rolhai.rm.core.season.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="seasons")
public class SeasonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String name;

    /**
     * name of the race simulation.
     * if empty it is a real world season.
     * <p>
     * example: F1 23
     */
    private String simulation;
}
