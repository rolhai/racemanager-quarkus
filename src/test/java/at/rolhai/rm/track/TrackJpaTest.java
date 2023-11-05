package at.rolhai.rm.track;

import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import at.rolhai.rm.country.control.CountryRepository;
import at.rolhai.rm.country.entity.CountryEntity;
import at.rolhai.rm.track.control.TrackRepository;
import at.rolhai.rm.track.entity.TrackEntity;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

/**
 * test cases for race track persistence
 */
@QuarkusTest
class TrackJpaTest {

    @Inject
    CountryRepository countryRepository;

    @Inject
    TrackRepository trackRepository;

    /**
     * save a track with a country.
     * change the country and save the track again.
     */
    @Test
    @Transactional
    void saveChangedCountry() {

        // save country at
        CountryEntity austria = countryRepository.findByCode("AUT");

        // assert id for country at
        Assertions.assertNotNull(austria.getId());
        Assertions.assertTrue(austria.getId() > 0);

        // save country de"
        CountryEntity germany = countryRepository.findByCode("GER");

        // assert id for country de
        Assertions.assertNotNull(germany.getId());
        Assertions.assertTrue(germany.getId() > 0);

        // save track with country de
        TrackEntity t1 = new TrackEntity();
        t1.setName("Hockenheimring");
        t1.setLocation("Hockenheim");
        t1.setTurns(40);
        t1.setLength(1500);
        t1.setNation(germany);
        t1.setWebsite("https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg");
        trackRepository.persist(t1);

        // assert id for track
        Long trackId = t1.getId();
        Assertions.assertNotNull(trackId);
        Assertions.assertTrue(trackId > 0);

        // load track by id
        TrackEntity deTrack = trackRepository.findById(trackId);

        // assert country do for track
        Assertions.assertNotNull(deTrack);
        Assertions.assertNotNull(deTrack.getNation());
        Assertions.assertEquals("GER", deTrack.getNation().getCode());

        // change country to at
        t1.setNation(austria);

        // load track by id
        TrackEntity atTrack = trackRepository.findById(trackId);

        // assert country at for track
        Assertions.assertNotNull(atTrack);
        Assertions.assertNotNull(atTrack.getNation());
        Assertions.assertEquals("AUT", atTrack.getNation().getCode());
    }

    /**
     * save a track with a country that ist not persistent.
     * it must fail.
     */
    @Test
    @Transactional
    void saveUnknownCountryFailes() {
        CountryEntity sweden = new CountryEntity();
        sweden.setCode("SWE");
        sweden.setName("Schweden");

        TrackEntity t1 = new TrackEntity();
        t1.setName("Hockenheimring");
        t1.setLocation("Hockenheim");
        t1.setTurns(40);
        t1.setLength(1500);
        t1.setNation(sweden);
        t1.setWebsite("https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg");

        try {
            trackRepository.persist(t1);
            Assertions.fail("save track with an unsaved country must fail");
        } catch (IllegalStateException ex) {
            Log.warn(ex);
            Assertions.assertTrue(ex.getMessage().contains("property references a transient value"));
        }
    }

    /**
     * save a track without a country.
     * it must fail.
     */
    @Test
    @Transactional
    void saveWithoutNationFailes() {
        TrackEntity t1 = new TrackEntity();
        t1.setName("Hockenheimring");
        t1.setLocation("Hockenheim");
        t1.setTurns(40);
        t1.setLength(1500);
        t1.setNation(null);
        t1.setWebsite("https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg");

        try {
            trackRepository.persist(t1);
            Assertions.fail("save track without country must fail");
        } catch (PropertyValueException ex) {
            Log.warn(ex);
            Assertions.assertTrue(ex.getMessage().contains("not-null property references a null or transient value"));
        }
    }
    
}
