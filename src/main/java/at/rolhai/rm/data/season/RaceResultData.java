package at.rolhai.rm.data.season;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class RaceResultData {

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate eventDate;

    public String trackName;

    public String eventType;

    public String driverFirstname;

    public String driverLastname;

    public String teamName;

    public Integer ranking;

    @JsonbDateFormat(value = DateTimeConfiguration.TIME_FORMAT)
    public LocalTime bestTime;
}
