package at.rolhai.rm.season;

import java.util.List;

import org.bson.types.ObjectId;

public class SeasonTeam {

    /**
     * order of the team in the season
     * 
     * example: 1
     */
    public int order;

    /**
     * ID of the team
     */
    public ObjectId teamId;

    /**
     * list of drivers of the team
     */
    public List<SeasonDriver> drivers;

}
