package at.rolhai.rm.season;

import java.util.List;

import org.bson.types.ObjectId;

public class SeasonTeam {

    /**
     * position of the team in the season
     * 
     * example: 1
     */
    public int position;

    /**
     * ID of the team
     */
    public ObjectId teamId;

    /**
     * list of drivers with the position in the team
     */
    public List<SeasonDriver> drivers;

}
