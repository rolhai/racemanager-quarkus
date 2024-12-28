package at.rolhai.rm.data.championship;

import at.rolhai.rm.data.core.SeasonData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ChampionshipData {

    private String simulation;

    private int seasonYear;

    private List<ChampionshipEventData> events;

    private List<ChampionshipTeamData> teams;

    private List<ChampionshipResultData> results;
}
