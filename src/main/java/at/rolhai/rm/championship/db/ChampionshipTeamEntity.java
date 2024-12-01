package at.rolhai.rm.championship.db;

import at.rolhai.rm.core.driver.db.DriverEntity;
import at.rolhai.rm.core.season.db.SeasonEntity;
import at.rolhai.rm.core.team.db.TeamEntity;
import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "championship_teams")
public class ChampionshipTeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "championshipId", foreignKey=@ForeignKey(name="fk_championship_teams_championshipId"), nullable = false)
    private ChampionshipEntity championship;

    @NotNull
    @OneToOne
    @JoinColumn(name = "teamId", foreignKey=@ForeignKey(name="fk_championship_teams_teamId"), nullable = false)
    private TeamEntity team;

    @NotNull
    @OneToOne
    @JoinColumn(name = "driver1Id", foreignKey=@ForeignKey(name="fk_championship_teams_driver1Id"), nullable = false)
    private DriverEntity driver1;

    @NotNull
    @OneToOne
    @JoinColumn(name = "driver2Id", foreignKey=@ForeignKey(name="fk_championship_teams_driver2Id"), nullable = false)
    private DriverEntity driver2;

    /**
     * order number of the event in a season
     *
     * example: 1
     */
    @NotNull
    private Integer orderNumber;
}
