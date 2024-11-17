package at.rolhai.rm.data.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class CoreData {

    private List<CountryData> countries;

    private List<DriverData> drivers;

    private List<TeamData> teams;

    private List<EventData> events;
}
