package at.rolhai.rm.season;

import java.util.Arrays;

import at.rolhai.rm.driver.DriverEntity;
import at.rolhai.rm.team.TeamEntity;
import at.rolhai.rm.track.TrackEntity;

public class SeasonBuilder {

    private SeasonEntity season = new SeasonEntity();

    public SeasonBuilder season(SeasonEntity season) {
        this.season = season;
        return this;
    }

    public SeasonBuilder team(
        int order, TeamEntity team, 
        DriverEntity driver1, DriverEntity driver2) {

        SeasonDriver seasonDriver1 = new SeasonDriver();
        seasonDriver1.order = 1;
        seasonDriver1.driverId = driver1.id;
        
        SeasonDriver seasonDriver2 = new SeasonDriver();
        seasonDriver2.order = 2;
        seasonDriver2.driverId = driver2.id;

        SeasonTeam seasonTeam = new SeasonTeam();
        seasonTeam.order = order;
        seasonTeam.drivers = Arrays.asList(seasonDriver1, seasonDriver2);
        seasonTeam.teamId = team.id;

        season.teams.add(seasonTeam);
        return this;
    }

    public SeasonBuilder event(String name,
        int order, TrackEntity trackEntity) {

        SeasonEvent event = new SeasonEvent();
        event.name = name;
        event.order = order;
        event.trackId = trackEntity.id;
        season.events.add(event);
        return this;
    }
    
}
