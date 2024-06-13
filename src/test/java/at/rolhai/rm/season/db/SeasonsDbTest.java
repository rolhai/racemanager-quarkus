package at.rolhai.rm.season.db;

import at.rolhai.rm.country.db.CountryEntity;
import at.rolhai.rm.country.db.CountryRepository;
import at.rolhai.rm.driver.db.DriverEntity;
import at.rolhai.rm.driver.db.DriverRepository;
import at.rolhai.rm.event.db.EventEntity;
import at.rolhai.rm.event.db.EventRepository;
import at.rolhai.rm.result.db.RaceResultEntity;
import at.rolhai.rm.result.db.RaceResultRepository;
import at.rolhai.rm.event.EventType;
import at.rolhai.rm.team.db.TeamEntity;
import at.rolhai.rm.team.db.TeamRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

@QuarkusTest
class SeasonsDbTest {

    @Inject
    EventRepository eventRepository;

    @Inject
    DriverRepository driverRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    TeamRepository teamRepository;

    @Inject
    SeasonRepository seasonRepository;

    @Inject
    RaceResultRepository raceResultRepository;
    
    @Test
    @TestTransaction
    void saveSeasonData() {
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
        verstappen.countryCode = netherlands.iocCode;
        driverRepository.persist(verstappen);
        Assertions.assertNotNull(verstappen);
        Assertions.assertNotNull(verstappen.id);

        DriverEntity perez = new DriverEntity();
        perez.firstname = "Sergio";
        perez.lastname = "Perez";
        perez.countryCode = mexico.iocCode;
        driverRepository.persist(perez);
        Assertions.assertNotNull(perez.id);

        EventEntity hockenheimring = new EventEntity();
        hockenheimring.eventName = "Großer Preis von Deutschland";
        hockenheimring.trackName = "Hockenheimring";
        hockenheimring.location = "Hockenheim";
        hockenheimring.countryCode = germany.iocCode;
        eventRepository.persist(hockenheimring);
        Assertions.assertNotNull(hockenheimring.id);

        EventEntity nuerburgring = new EventEntity();
        nuerburgring.eventName = "Großer Preis von Europa";
        nuerburgring.trackName = "Nürburgring";
        nuerburgring.location = "Nürbung";
        nuerburgring.countryCode = germany.iocCode;
        eventRepository.persist(nuerburgring);
        Assertions.assertNotNull(nuerburgring.id);

        TeamEntity redBull = new TeamEntity();
        redBull.name = "Red Bull";
        redBull.engine = "Honda";
        redBull.companyLocation = "Milton Keynes";
        redBull.companyCountryCode = britain.iocCode;
        redBull.licenceCountryCode = austria.iocCode;
        teamRepository.persist(redBull);
        Assertions.assertNotNull(redBull.id);

        SeasonEntity season2023 = new SeasonEntity();
        season2023.seasonYear = 2023;
        season2023.league = "Formel 1";
        season2023.seasonName = "Weltmeisterschaft";
        season2023.simulation = "F1 23";
        season2023.startDate = LocalDate.of(2023, Month.APRIL, 24);
        season2023.endDate = LocalDate.of(2023, Month.NOVEMBER, 19);
        seasonRepository.persist(season2023);
        Assertions.assertNotNull(season2023.id);

        RaceResultEntity hockenheimPole2023 = new RaceResultEntity();
        hockenheimPole2023.seasonId = season2023.id;
        hockenheimPole2023.eventType = EventType.QUALIFYING;
        hockenheimPole2023.ranking = 2;
        hockenheimPole2023.eventDate = LocalDate.of(2020, Month.JULY, 17);
        hockenheimPole2023.setBestTime(LocalTime.of(0, 1, 24, 372));
        hockenheimPole2023.driverFirstname = verstappen.firstname;
        hockenheimPole2023.driverLastname = verstappen.lastname;
        hockenheimPole2023.trackName = hockenheimring.trackName;
        hockenheimPole2023.teamName = redBull.name;
        raceResultRepository.persist(hockenheimPole2023);
        Assertions.assertNotNull(hockenheimPole2023.id);
        
        RaceResultEntity hockenheimWinner2023 = new RaceResultEntity();
        hockenheimWinner2023.seasonId = season2023.id;
        hockenheimWinner2023.eventType = EventType.RACE;
        hockenheimWinner2023.ranking = 1;
        hockenheimWinner2023.eventDate = LocalDate.of(2020, Month.JULY, 18);
        hockenheimWinner2023.setBestTime(LocalTime.of(0, 1, 25, 187));
        hockenheimWinner2023.driverFirstname = verstappen.firstname;
        hockenheimWinner2023.driverLastname = verstappen.lastname;
        hockenheimWinner2023.trackName = hockenheimring.trackName;
        hockenheimWinner2023.teamName = redBull.name;
        raceResultRepository.persist(hockenheimWinner2023);
        Assertions.assertNotNull(hockenheimWinner2023.id);
    }
}
