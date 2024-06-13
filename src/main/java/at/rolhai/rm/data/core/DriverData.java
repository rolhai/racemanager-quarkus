package at.rolhai.rm.data.core;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDate;

public class DriverData {

    public Long number;

    public String firstname;

    public String lastname;

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate birthday;

    public String countryCode;

    public String website;

    public boolean player;
}
