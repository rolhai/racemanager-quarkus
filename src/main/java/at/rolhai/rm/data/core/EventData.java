package at.rolhai.rm.data.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventData {

    private String eventName;

    private String trackName;

    private String location;

    private String countryCode;

    private String website;
}
