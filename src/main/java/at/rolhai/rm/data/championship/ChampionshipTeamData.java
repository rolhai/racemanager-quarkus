package at.rolhai.rm.data.championship;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChampionshipTeamData {

    private Integer orderNumber;

    private String teamName;

    private String driver1Firstname;

    private String driver1Lastname;

    private String driver2Firstname;

    private String driver2Lastname;
}
