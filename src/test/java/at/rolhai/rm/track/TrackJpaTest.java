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

        // update
        trackEntity.laps = 45;
        trackRepository.update(trackEntity);

        Assertions.assertEquals(40, found.laps);
        Assertions.assertEquals(45, trackEntity.laps);

        count = trackRepository.count();
        Assertions.assertEquals(1, count);

        trackRepository.deleteById(trackEntity.id);

        // delete
        count = trackRepository.count();
        Assertions.assertEquals(0, count);
    }
}
