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
     * order number of the track in the season
     * 
     * example: 1
     */
    public int orderNumber;

    /**
     * ID ot the track
     * 
     * example: ID of the Hockenheimring, DE
     */
    public ObjectId trackId;

}
