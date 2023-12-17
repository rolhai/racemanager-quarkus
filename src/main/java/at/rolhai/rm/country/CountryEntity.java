package at.rolhai.rm.country;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * country of a driver, team or track.
 * 
 * country codes defined by the 'International Olympic Committee' (IOC) are used.
 * 
 * @see https://de.wikipedia.org/wiki/Liste_der_IOC-L%C3%A4ndercodes
 * @see https://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste
 */
@MongoEntity(collection="Country")
public class CountryEntity extends PanacheMongoEntity {

    /**
     * IOC code - alpha-3
     * 
     * example: AUT
     */
    public String iocCode;

     /**
     * name of the country
     * 
     * example: Österreich
     */
    public String name;

    /**
     * website
     * 
     * example: https://de.wikipedia.org/wiki/%C3%96sterreich
     */
    public String website;
}
