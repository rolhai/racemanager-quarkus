package at.rolhai.rm.data.season;

import at.rolhai.rm.app.DateTimeConfiguration;
import jakarta.json.bind.annotation.JsonbDateFormat;

import java.time.LocalDate;
import java.util.List;

public class SeasonData {

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate startDate;

    @JsonbDateFormat(value = DateTimeConfiguration.DATE_FORMAT)
    public LocalDate endDate;

    public Integer seasonYear;

    public String league;

    public String seasonName;

    public String simulation;

    public List<RaceResultData> results;
}
