package at.rolhai.rm.season;

import java.util.Arrays;

import at.rolhai.rm.driver.DriverEntity;
import at.rolhai.rm.team.TeamEntity;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class SeasonBuilder {

    public void addTeam(SeasonEntity season, TeamEntity team, DriverEntity driver1, DriverEntity driver2) {
        SeasonDriver seasonDriver1 = new SeasonDriver();
        seasonDriver1.position = 1;
        seasonDriver1.driverId = driver1.id;
        
        SeasonDriver seasonDriver2 = new SeasonDriver();
        seasonDriver2.position = 2;
        seasonDriver2.driverId = driver2.id;

        SeasonTeam seasonTeam = new SeasonTeam();
        seasonTeam.drivers = Arrays.asList(seasonDriver1, seasonDriver2);
        seasonTeam.teamId = team.id;

        season.teams.add(seasonTeam);
    }
    
}
