package at.rolhai.rm.season;

import org.bson.types.ObjectId;

public class SeasonEvent {

    /**
     * name of the event
     * 
     * example: Grand Prix von Deutschland
     */
    public String name;

    /**
     * order of the track in the season
     * 
     * example: 1
     */
    public int order;

    /**
     * ID ot the track
     * 
     * example: ID of the Hockenheimring, DE
     */
    public ObjectId trackId;

}
