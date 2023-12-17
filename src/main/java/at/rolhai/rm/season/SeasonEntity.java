package at.rolhai.rm.season;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="Season")
public class SeasonEntity extends PanacheMongoEntity {

    /**
     * The beginning of the season
     */
    public LocalDate start;

    /**
     * year of the season
     * 
     * example: 2023
     */
    public int year;

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
    public String name;

    /**
     * the events of the season
     */
    public List<SeasonEvent> events = new ArrayList<>();

    /**
     * the teams of the season
     */
    public List<SeasonTeam> teams = new ArrayList<>();

}
