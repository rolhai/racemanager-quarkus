package at.rolhai.rm.track;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * A race track
 * 
 * @see https://de.wikipedia.org/wiki/Liste_der_Formel-1-Rennstrecken
 */
@MongoEntity(collection="Track")
public class TrackEntity extends PanacheMongoEntity {

    /**
     * name ot the track
     * 
     * example: Hockenheimring
     */
    public String name;

    /**
     * number of laps
     * 
     * example: 65
     */
    public Integer laps;

    /**
     * length of a lap in km
     * 
     * example: 4,574 km
     */
    public Double length;

    /**
     * location of the track
     * 
     * example: Am Motodrom, Hockenheim
     */
    public String location;

    /**
     * country where the track is located
     * 
     * mappend to Country.id
     * 
     * example: DE
     */
    public ObjectId countryId;

    /**
     * website of the track
     * 
     * example: https://de.wikipedia.org/wiki/Hockenheimring_Baden-W%C3%BCrttemberg
     */
    public String website;

}
