package at.rolhai.rm.data.core;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class DriverData {

    private Long number;

    private String firstname;

    private String lastname;

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    private LocalDate birthday;

    private String countryCode;

    private String website;

    private boolean player;
}
