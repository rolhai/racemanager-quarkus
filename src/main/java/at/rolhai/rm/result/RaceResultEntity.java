package at.rolhai.rm.result;

import java.time.LocalDate;
import java.time.LocalTime;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection="RaceResult")
public class RaceResultEntity extends PanacheMongoEntity {

    /**
     * ID of the season
     */
    public ObjectId seasonId;

    /**
     * Date when the event happened
     * 
     * example: 01.06.2021
     */
    public LocalDate eventDate;

    /**
     * ID of the track
     */
    public ObjectId trackId;

    /**
     * ID of the driver
     */
    public ObjectId driverId;

    /**
     * Type of event
     * 
     * example: 'R' ... race
     */
    public String eventType;

    /**
     * Position in the event
     * 
     * example: 1 ... first place
     */
    public int position;

    /**
     * Best time of the driver for this event
     * 
     * example: 1:36:24
     */
    public LocalTime bestTime;
    
}
