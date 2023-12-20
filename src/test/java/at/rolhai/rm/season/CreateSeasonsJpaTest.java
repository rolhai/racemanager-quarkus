package at.rolhai.rm.season;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import at.rolhai.rm.company.CompanyEntity;
import at.rolhai.rm.company.CompanyRepository;
import at.rolhai.rm.country.CountryEntity;
import at.rolhai.rm.country.CountryRepository;
import at.rolhai.rm.driver.DriverEntity;
import at.rolhai.rm.driver.DriverRepository;
import at.rolhai.rm.result.RaceResultEntity;
import at.rolhai.rm.result.RaceResultRepository;
import at.rolhai.rm.team.TeamEntity;
import at.rolhai.rm.team.TeamRepository;
import at.rolhai.rm.track.TrackEntity;
import at.rolhai.rm.track.TrackRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class CreateSeasonsJpaTest {

    @Inject
    TrackRepository trackRepository;

    @Inject
    DriverRepository driverRepository;

    @Inject
    RaceResultRepository eventResultRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    CompanyRepository companyRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    SeasonRepository seasonRepository;

    @Inject
    RaceResultRepository seasonEventResultRepository;
    
    @Test
    @TestTransaction
    void saveEventResult() {
        CountryEntity britain = new CountryEntity();
        britain.iocCode = "GBR";
        britain.name = "Großbritannien";
        countryRepository.persist(britain);
        Assertions.assertNotNull(britain.id);

        CountryEntity austria = new CountryEntity();
        austria.iocCode = "AUT";
        austria.name = "Österrreich";
        countryRepository.persist(austria);
        Assertions.assertNotNull(austria.id);

        CountryEntity netherlands = new CountryEntity();
        netherlands.iocCode = "NED";
        netherlands.name = "Niederlande";
        countryRepository.persist(netherlands);
        Assertions.assertNotNull(netherlands.id);

        CountryEntity mexico = new CountryEntity();
        mexico.iocCode = "MEX";
        mexico.name = "Mexiko";
        countryRepository.persist(mexico);
        Assertions.assertNotNull(mexico.id);

        CountryEntity germany = new CountryEntity();
        germany.iocCode = "GER";
        germany.name = "Deutschland";
        countryRepository.persist(germany);
        Assertions.assertNotNull(germany.id);

        DriverEntity verstappen = new DriverEntity();
        verstappen.firstname = "Max";
        verstappen.lastname = "Verstappen";
        verstappen.countryId = netherlands.id;
        driverRepository.persist(verstappen);
        Assertions.assertNotNull(verstappen);
        Assertions.assertNotNull(verstappen.id);

        DriverEntity perez = new DriverEntity();
        perez.firstname = "Sergio";
        perez.lastname = "Perez";
        perez.countryId = mexico.id;
        driverRepository.persist(perez);
        Assertions.assertNotNull(perez.id);

        TrackEntity hockenheimring = new TrackEntity();
        hockenheimring.name = "Hockenheimring";
        hockenheimring.location = "Hockenheim";
        hockenheimring.countryId = germany.id;
        trackRepository.persist(hockenheimring);
        Assertions.assertNotNull(hockenheimring.id);

        TrackEntity nuerburgring = new TrackEntity();
        nuerburgring.name = "Nürburgring";
        nuerburgring.location = "Nürbung";
        nuerburgring.countryId = germany.id;
        trackRepository.persist(nuerburgring);
        Assertions.assertNotNull(nuerburgring.id);

        CompanyEntity redBullRacing = new CompanyEntity();
        redBullRacing.name = "Red Bull Racing";
        redBullRacing.location = "Milton Keynes";
        redBullRacing.countryId = britain.id;
        companyRepository.persist(redBullRacing);
        Assertions.assertNotNull(redBullRacing.id);

        TeamEntity redBull = new TeamEntity();
        redBull.name = "Red Bull";
        redBull.engine = "Honda RBPT";
        redBull.chassis = "RB19";
        redBull.licenceCountryId = austria.id;
        redBull.companyId = redBullRacing.id;
        teamRepository.persist(redBull);
        Assertions.assertNotNull(redBull.id);

        SeasonEntity season2023 = new SeasonEntity();
        season2023.year = 2023;
        season2023.league = "Formel 1";
        season2023.name = "Weltmeisterschaft";
        season2023.start = LocalDate.of(2023, Month.APRIL, 24);
        new SeasonBuilder()
            .season(season2023)
            .team(1, redBull, verstappen, perez)
            .event("Großer Preis von Deutschland", 1, hockenheimring)
            .event("Großer Preis von Europa", 2, nuerburgring);
        seasonRepository.persist(season2023);
        Assertions.assertNotNull(season2023.id);

        RaceResultEntity hockenheimPole2023 = new RaceResultEntity();
        hockenheimPole2023.seasonId = season2023.id;
        hockenheimPole2023.eventType = EventType.QUALIFYING;
        hockenheimPole2023.ranking = 2;
        hockenheimPole2023.eventDate = LocalDate.of(2020, Month.JULY, 17);
        hockenheimPole2023.bestTime = LocalTime.of(1, 24, 37);
        hockenheimPole2023.driverId = verstappen.id; 
        hockenheimPole2023.trackId = hockenheimring.id;
        seasonEventResultRepository.persist(hockenheimPole2023);
        Assertions.assertNotNull(hockenheimPole2023.id);
        
        RaceResultEntity hockenheimWinner2023 = new RaceResultEntity();
        hockenheimWinner2023.seasonId = season2023.id;
        hockenheimWinner2023.eventType = EventType.RACE;
        hockenheimWinner2023.ranking = 1;
        hockenheimWinner2023.eventDate = LocalDate.of(2020, Month.JULY, 18);
        hockenheimWinner2023.bestTime = LocalTime.of(1, 25, 18);
        hockenheimWinner2023.driverId = verstappen.id; 
        hockenheimWinner2023.trackId = hockenheimring.id;
        seasonEventResultRepository.persist(hockenheimWinner2023);
        Assertions.assertNotNull(hockenheimWinner2023.id);
    }
}
