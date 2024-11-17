package at.rolhai.rm.data.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamData {

    private String name;

    private String engine;

    private String companyLocation;

    private String companyCountryCode;

    private String licenceCountryCode;

    private String website;
}
