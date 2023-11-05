package at.rolhai.rm.track.entity;

import at.rolhai.rm.country.entity.CountryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tracks",
    uniqueConstraints = { 
        @UniqueConstraint(name = "uc_track_name", columnNames = { "name" }) 
})
public class TrackEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String name;

    private Long turns;

    private Long length;

    @Column(columnDefinition = "varchar(50)")
    private String location;

    @ManyToOne(optional=false)
    @JoinColumn(name="countryId", nullable = false, foreignKey = @ForeignKey(name="fk_track_country"))
    private CountryEntity nation;

    @Column(columnDefinition = "varchar(100)")
    private String website;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTurns() {
        return turns;
    }

    public void setTurns(long turns) {
        this.turns = turns;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CountryEntity getNation() {
        return nation;
    }

    public void setNation(CountryEntity nation) {
        this.nation = nation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    
    
}
