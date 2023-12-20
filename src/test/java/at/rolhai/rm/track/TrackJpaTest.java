package at.rolhai.rm.track;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

/**
 * test cases for race track persistence
 */
@QuarkusTest
class TrackJpaTest {

    @Inject
    TrackRepository trackRepository;

    @Test
    @TestTransaction
    void testCrud() {
        long count = trackRepository.count();
        Assertions.assertEquals(0, count);

        TrackEntity trackEntity = new TrackEntity();
        trackEntity.name = "Hockenheimring";
        trackEntity.location = "Hockenheim";
        trackEntity.laps = 40;
        trackEntity.length = 1.432;

        // create
        trackRepository.persist(trackEntity);
        Assertions.assertNotNull(trackEntity.id);

        count = trackRepository.count();
        Assertions.assertEquals(1, count);

        // read
        TrackEntity found = trackRepository.findByFilter("Hockenheimring").stream()
            .findFirst()
            .orElse(null);
        Assertions.assertNotNull(found);
        Assertions.assertEquals(trackEntity.id, found.id);
        Assertions.assertEquals(40, found.laps);

        // update
        trackEntity.laps = 45;
        trackRepository.update(trackEntity);

        count = trackRepository.count();
        Assertions.assertEquals(1, count);

        // read
        found = trackRepository.findByFilter("Hockenheimring").stream()
            .findFirst()
            .orElse(null);
        Assertions.assertNotNull(found);
        Assertions.assertEquals(trackEntity.id, found.id);
        Assertions.assertEquals(45, found.laps);

        // delete
        trackRepository.deleteById(trackEntity.id);

        count = trackRepository.count();
        Assertions.assertEquals(0, count);
    }
}
