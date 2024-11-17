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
        britain.setIocCode("GBR");
        britain.setName("Großbritannien");
        countryRepository.persist(britain);
        Assertions.assertNotNull(britain.getId());

        CountryEntity austria = new CountryEntity();
        austria.setIocCode("AUT");
        austria.setName("Österrreich");
        countryRepository.persist(austria);
        Assertions.assertNotNull(austria.getId());

        CountryEntity netherlands = new CountryEntity();
        netherlands.setIocCode("NED");
        netherlands.setName("Niederlande");
        countryRepository.persist(netherlands);
        Assertions.assertNotNull(netherlands.getId());

        CountryEntity mexico = new CountryEntity();
        mexico.setIocCode("MEX");
        mexico.setName("Mexiko");
        countryRepository.persist(mexico);
        Assertions.assertNotNull(mexico.getId());

        CountryEntity germany = new CountryEntity();
        germany.setIocCode("GER");
        germany.setName("Deutschland");
        countryRepository.persist(germany);
        Assertions.assertNotNull(germany.getId());

        DriverEntity verstappen = new DriverEntity();
        verstappen.setFirstname("Max");
        verstappen.setLastname("Verstappen");
        verstappen.setCountryCode(netherlands.getIocCode());
        driverRepository.persist(verstappen);
        Assertions.assertNotNull(verstappen);
        Assertions.assertNotNull(verstappen.getId());

        DriverEntity perez = new DriverEntity();
        perez.setFirstname("Sergio");
        perez.setLastname("Perez");
        perez.setCountryCode(mexico.getIocCode());
        driverRepository.persist(perez);
        Assertions.assertNotNull(perez.getId());

        EventEntity hockenheimring = new EventEntity();
        hockenheimring.setEventName("Großer Preis von Deutschland");
        hockenheimring.setTrackName("Hockenheimring");
        hockenheimring.setLocation("Hockenheim");
        hockenheimring.setCountryCode(germany.getIocCode());
        eventRepository.persist(hockenheimring);
        Assertions.assertNotNull(hockenheimring.getId());

        EventEntity nuerburgring = new EventEntity();
        nuerburgring.setEventName("Großer Preis von Europa");
        nuerburgring.setTrackName("Nürburgring");
        nuerburgring.setLocation("Nürbung");
        nuerburgring.setCountryCode(germany.getIocCode());
        eventRepository.persist(nuerburgring);
        Assertions.assertNotNull(nuerburgring.getId());

        TeamEntity redBull = new TeamEntity();
        redBull.setName("Red Bull");
        redBull.setEngine("Honda");
        redBull.setCompanyLocation("Milton Keynes");
        redBull.setCompanyCountryCode(britain.getIocCode());
        redBull.setLicenceCountryCode(austria.getIocCode());
        teamRepository.persist(redBull);
        Assertions.assertNotNull(redBull.getId());

        SeasonEntity season2023 = new SeasonEntity();
        season2023.setSeasonYear(2023);
        season2023.setLeague("Formel 1");
        season2023.setSeasonName("Weltmeisterschaft");
        season2023.setSimulation("F1 23");
        season2023.setStartDate(LocalDate.of(2023, Month.APRIL, 24));
        season2023.setEndDate(LocalDate.of(2023, Month.NOVEMBER, 19));
        seasonRepository.persist(season2023);
        Assertions.assertNotNull(season2023.getId());

        RaceResultEntity hockenheimPole2023 = new RaceResultEntity();
        hockenheimPole2023.setSeasonId(season2023.getId());
        hockenheimPole2023.setEventType(EventType.QUALIFYING);
        hockenheimPole2023.setRanking(2);
        hockenheimPole2023.setEventDate(LocalDate.of(2020, Month.JULY, 17));
        hockenheimPole2023.setBestTime(LocalTime.of(0, 1, 24, 372));
        hockenheimPole2023.setDriverFirstname(verstappen.getFirstname());
        hockenheimPole2023.setDriverLastname(verstappen.getLastname());
        hockenheimPole2023.setTrackName(hockenheimring.getTrackName());
        hockenheimPole2023.setTeamName(redBull.getName());
        raceResultRepository.persist(hockenheimPole2023);
        Assertions.assertNotNull(hockenheimPole2023.getId());
        
        RaceResultEntity hockenheimWinner2023 = new RaceResultEntity();
        hockenheimWinner2023.setSeasonId(season2023.getId());
        hockenheimWinner2023.setEventType(EventType.RACE);
        hockenheimWinner2023.setRanking(1);
        hockenheimWinner2023.setEventDate(LocalDate.of(2020, Month.JULY, 18));
        hockenheimWinner2023.setBestTime(LocalTime.of(0, 1, 25, 187));
        hockenheimWinner2023.setDriverFirstname(verstappen.getFirstname());
        hockenheimWinner2023.setDriverLastname(verstappen.getLastname());
        hockenheimWinner2023.setTrackName(hockenheimring.getTrackName());
        hockenheimWinner2023.setTeamName(redBull.getName());
        raceResultRepository.persist(hockenheimWinner2023);
        Assertions.assertNotNull(hockenheimWinner2023.getId());
    }
}
