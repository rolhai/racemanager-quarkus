package at.rolhai.rm.data.championship;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class ChampionshipResultData {

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate eventDate;

    private String location;

    private String eventType;

    private String driverFirstname;

    private String driverLastname;

    private String teamName;

    private Integer ranking;

    @JsonbDateFormat(value = DateTimeConfiguration.TIME_FORMAT)
    private LocalTime bestTime;
}
