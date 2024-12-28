package at.rolhai.rm.championship.db;

import at.rolhai.rm.core.country.db.CountryEntity;
import at.rolhai.rm.core.country.db.CountryRepository;
import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.driver.db.DriverRepository;
import at.rolhai.rm.core.event.db.EventEntity;
import at.rolhai.rm.core.event.db.EventRepository;
import at.rolhai.rm.core.season.db.SeasonEntity;
import at.rolhai.rm.core.season.db.SeasonRepository;
import at.rolhai.rm.core.event.EventType;
import at.rolhai.rm.core.team.db.TeamEntity;
import at.rolhai.rm.core.team.db.TeamRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@QuarkusTest
class ChampionshipDbTest {

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
    ChampionshipRepository championshipRepository;

    @Inject
    ChampionshipTeamRepository championshipTeamRepository;

    @Inject
    ChampionshipEventRepository championshipEventRepository;

    @Inject
    ChampionshipResultRepository championshipResultRepository;
    
    @Test
    @TestTransaction
    void saveChampionshipData() {
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
        season2023.setName("Weltmeisterschaft");
        season2023.setSimulation("F1 23");
        seasonRepository.persist(season2023);
        Assertions.assertNotNull(season2023.getId());

        ChampionshipEntity championship2023 = new ChampionshipEntity();
        championship2023.setSeason(season2023);

        ChampionshipTeamEntity championshipRedBull = new ChampionshipTeamEntity();
        championshipRedBull.setChampionship(championship2023);
        championshipRedBull.setTeam(redBull);
        championshipRedBull.setDriver1(verstappen);
        championshipRedBull.setDriver2(perez);
        championship2023.setTeams(List.of(championshipRedBull));

        ChampionshipEventEntity championshipHockenheim = new ChampionshipEventEntity();
        championshipHockenheim.setChampionship(championship2023);
        championshipHockenheim.setOrderNumber(1);
        championshipHockenheim.setEvent(hockenheimring);
        ChampionshipEventEntity championshipNuerburgring = new ChampionshipEventEntity();
        championshipNuerburgring.setChampionship(championship2023);
        championshipNuerburgring.setOrderNumber(2);
        championshipNuerburgring.setEvent(nuerburgring);
        championship2023.setEvents(List.of(championshipHockenheim, championshipNuerburgring));

        championshipRepository.persist(championship2023);
        championshipEventRepository.persist(championshipHockenheim);
        championshipEventRepository.persist(championshipNuerburgring);
        championshipTeamRepository.persist(championshipRedBull);
        Assertions.assertNotNull(championship2023.getId());
        Assertions.assertNotNull(championshipRedBull.getId());
        Assertions.assertNotNull(championshipHockenheim.getId());
        Assertions.assertNotNull(championshipNuerburgring.getId());

        ChampionshipResultEntity hockenheimPole2023 = new ChampionshipResultEntity();
        hockenheimPole2023.setChampionship(championship2023);
        hockenheimPole2023.setEventType(EventType.QUALIFYING);
        hockenheimPole2023.setRanking(2);
        hockenheimPole2023.setEventDate(LocalDate.of(2020, Month.JULY, 17));
        hockenheimPole2023.setBestTime(LocalTime.of(0, 1, 24, 372));
        hockenheimPole2023.setDriver(verstappen);
        hockenheimPole2023.setEvent(hockenheimring);
        hockenheimPole2023.setTeam(redBull);
        championshipResultRepository.persist(hockenheimPole2023);
        Assertions.assertNotNull(hockenheimPole2023.getId());
        
        ChampionshipResultEntity hockenheimWinner2023 = new ChampionshipResultEntity();
        hockenheimWinner2023.setChampionship(championship2023);
        hockenheimWinner2023.setEventType(EventType.RACE);
        hockenheimWinner2023.setRanking(1);
        hockenheimWinner2023.setEventDate(LocalDate.of(2020, Month.JULY, 18));
        hockenheimWinner2023.setBestTime(LocalTime.of(0, 1, 25, 187));
        hockenheimWinner2023.setDriver(verstappen);
        hockenheimWinner2023.setEvent(hockenheimring);
        hockenheimWinner2023.setTeam(redBull);
        championshipResultRepository.persist(hockenheimWinner2023);
        Assertions.assertNotNull(hockenheimWinner2023.getId());
    }
}
