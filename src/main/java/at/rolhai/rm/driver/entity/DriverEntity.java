package at.rolhai.rm.driver.entity;

import java.time.ZonedDateTime;

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
@Table(name = "drivers", 
    uniqueConstraints = { 
        @UniqueConstraint(name = " uc_driver_firstname_lastname", columnNames = { "firstname", "lastname" }) 
})
public class DriverEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long number;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String firstname;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String lastname;

    private ZonedDateTime birthday;

    @ManyToOne(optional=false)
    @JoinColumn(name="countryId", nullable = false, foreignKey = @ForeignKey(name="fk_driver_country"))
    private CountryEntity nationality;

    @Column(columnDefinition = "varchar(100)")
    private String website;

    @Column(columnDefinition = "tinyint default 0", nullable = false)
    private boolean player;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) {
        this.birthday = birthday;
    }

    public CountryEntity getNationality() {
        return nationality;
    }

    public void setNationality(CountryEntity nationality) {
        this.nationality = nationality;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }
}
