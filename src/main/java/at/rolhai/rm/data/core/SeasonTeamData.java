package at.rolhai.rm.data.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeasonTeamData {

    private Integer orderNumber;

    private String teamName;

    private String driver1Firstname;

    private String driver1Lastname;

    private String driver2Firstname;

    private String driver2Lastname;
}
