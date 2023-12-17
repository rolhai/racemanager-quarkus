package at.rolhai.rm.team;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * A racing team
 */
@MongoEntity(collection="Team")
public class TeamEntity extends PanacheMongoEntity {
    
    /**
     * name of the team
     * 
     * example: Red Bull
     */
    public String name;

    /**
     * company behind the team
     * 
     * example: Milton Keynes, GB
     */
    public ObjectId companyId;

    /**
     * name of the car chassis
     * 
     * example: RB19
     */
    public String chassis;

    /**
     * engine of the race car
     * 
     * example: Honda RBPT
     */
    public String engine;

    /**
     * the teams drives with the license from this country
     */
    public ObjectId licenceCountryId;


}
