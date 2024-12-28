package at.rolhai.rm.data.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SeasonData {

    private Integer seasonYear;

    private String league;

    private String name;

    private String simulation;

    private List<SeasonEventData> events;

    private List<SeasonTeamData> teams;
}
