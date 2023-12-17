package at.rolhai.rm.company;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * The company managing a team
 */
@MongoEntity(collection="Company")
public class CompanyEntity extends PanacheMongoEntity {

    /**
     * name of the company
     * 
     * example: Red Bull Racing
     */
    public String name;

    /**
     * location of the home base
     * 
     * example: Milton Keynes 
     */
    public String location;

    /**
     * country of the home base
     * 
     * example: GB
     */
    public ObjectId countryId;

    /**
     * website
     * 
     * example: https://de.wikipedia.org/wiki/Red_Bull_Racing
     */
    public String website;

}
